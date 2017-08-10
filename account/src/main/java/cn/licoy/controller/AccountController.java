package cn.licoy.controller;

import cn.licoy.bean.User;
import cn.licoy.util.CheckUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * @author 刘杰
 * @version 1.0 /
 */
@Controller
public class AccountController {

    private final String token_name = "login_token";
    private String token_value = null;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String account_view(HttpServletRequest request, Model model){
        model.addAttribute("request",request);
        return "index";
    }

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    @ResponseBody
    public String check(User user,@RequestParam("url") String url) throws IOException {
        List<String> domain = new ArrayList<>();
        domain.add("a.com:8080");
        domain.add("b.com:8080");
        boolean b = CheckUtils.checkLogin(user.getUsername(),user.getPassword());
        StringBuilder s = new StringBuilder();
        if(b){
            this.token_value = Base64.getEncoder().encodeToString(user.getUsername().getBytes());
            for (String str:domain) {
                s.append("<script src=\"http://")
                        .append(str)
                        .append("/user/account_login?id=")
                        .append(token_value).append("&token=")
                        .append(CheckUtils.account_token)
                        .append("&time=")
                        .append(new Date().getTime())
                        .append("\"></script>");
            }
        }
        s.append("<script>setTimeout(function(){" + "location=\"").append(url).append("\"").append("},1200)</script>");
        return s.toString();
    }

}
