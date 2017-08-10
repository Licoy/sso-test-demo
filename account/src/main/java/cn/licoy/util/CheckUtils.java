package cn.licoy.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘杰
 * @version 1.0 /
 */
public class CheckUtils {
    private static final String username = "admin";
    private static final String password = "123456";
    public static final String account_token = "7E6D165138E6BA62265DDF22069D64EE";

    public static boolean checkLogin(String n, String p){
        Map<String,Object> map = new HashMap<>();
        if(!username.equals(n)){
            /*map.put("code",304);
            map.put("msg","用户名不存在");*/
            return false;
        }else if(!password.equals(p)){
            /*map.put("code",304);
            map.put("msg","密码错误");*/
            return false;
        }else{
            /*map.put("code",200);
            map.put("msg","登陆成功");*/
            return true;
        }
//        return map;
    }
}
