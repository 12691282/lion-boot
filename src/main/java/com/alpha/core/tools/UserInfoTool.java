package com.alpha.core.tools;

import com.alpha.module.system.bean.UserInfoBean;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UserInfoTool {

    private static Map<String, UserInfoBean> userCacheMap = new HashMap<>();

    public static void setUserInfo(UserInfoBean userInfo) {
        userCacheMap.put(userInfo.getToken(), userInfo);
    }

    public static UserInfoBean getUserInfo(HttpServletRequest request) {
        Object token = request.getHeader("token");
       return userCacheMap.get(token.toString());
    }

    public static void removeUserInfoByToken(String toString) {
        userCacheMap.remove(toString);
    }
}
