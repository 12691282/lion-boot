package com.alpha.core.tools;


import com.alpha.module.system.bean.UserInfoBean;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class TokenTools {


    public static final  String getToken(){
        return TokenProccessor.getInstance().makeToken();
    }

    /**
     * userBean 用户信息放入session
     * @param userBean
     * @param UserInfoBean
     */
    public static void createToken(HttpServletRequest request, UserInfoBean userBean){
        request.getSession().setAttribute(userBean.getToken(), userBean);
    }

    /**
     * 移除token
     * @param request
     * @param tokenServerkey
     */
    public static void removeToken(HttpServletRequest request, String token){
        request.getSession().removeAttribute(token);
    }

    /**
     * 判断请求参数中的token是否和session中一致
     * @param request
     * @param tokenClientkey
     * @param tokenServerkey
     * @return
     */
    public static boolean judgeTokenIsEqual(HttpServletRequest request, String tokenKey){

        String token_server = (String) request.getSession().getAttribute(tokenKey);
        if(StringUtils.isEmpty(token_server)){
            return false;
        }

        if(!token_server.equals(tokenKey)){
            return false;
        }

        return true;
    }

}
/**
 * 生成Token的类
 */
class TokenProccessor {

    private TokenProccessor(){}

    private static final TokenProccessor instance = new TokenProccessor();

    public static TokenProccessor getInstance() {
            return instance;
    }

    /**
     * 生成Token
     * @return
     */
    public String makeToken() {
            String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
            try {
                MessageDigest md = MessageDigest.getInstance("md5");
                 byte md5[] =  md.digest(token.getBytes());
                BASE64Encoder encoder = new BASE64Encoder();
                token =  encoder.encode(md5);
            } catch (NoSuchAlgorithmException e) {
                 e.printStackTrace();
            }
            return token;
    }
 }