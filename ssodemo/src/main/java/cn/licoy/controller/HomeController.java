package cn.licoy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

/**
 * @author 刘杰
 * @version 1.0 /
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String s = "{ not login }";
        if(cookies!=null && cookies.length>0){
            for (Cookie c : cookies){
                if("login_token".equals(c.getName())){
                    s = new String(Base64.getDecoder().decode(c.getValue()));
                }
            }
        }
        model.addAttribute("username",s);
        return "home";
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }



}
