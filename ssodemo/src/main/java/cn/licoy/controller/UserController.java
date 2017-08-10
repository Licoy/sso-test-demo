package cn.licoy.controller;

import cn.licoy.bean.User;
import cn.licoy.util.CheckUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Map;

/**
 * @author 刘杰
 * @version 1.0 /
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    /*@RequestMapping(value = "/login",method = RequestMethod.POST)
    public boolean login(User user, HttpServletResponse response){
        boolean b = CheckUtils.checkLogin(user.getUsername(),user.getPassword());
        if(b){
            Cookie cookie = new Cookie("login_token", Base64.getEncoder().encodeToString(user.getUsername().getBytes()));
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return b;
    }*/

    @RequestMapping(value = "/account_login",method = RequestMethod.GET)
    @ResponseBody
    public String account_login(@RequestParam("id") String id,@RequestParam("token") String token,HttpServletResponse response){
        StringBuilder str = new StringBuilder();
        if(CheckUtils.account_token.equals(token)){
            Cookie cookie = new Cookie("login_token",id);
            cookie.setPath("/");
            response.addCookie(cookie);
            str.append("<script>location=\"/\"</script>");
        }else{
            str.append("<script>location=\"http://account.com\"</script>");
        }
        return str.toString();
    }




}
