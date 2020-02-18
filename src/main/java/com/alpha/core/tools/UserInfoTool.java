package com.alpha.core.tools;

import com.alpha.module.system.bean.UserInfoBean;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class UserInfoTool {

    private static List<UserInfoBean> userCacheList = new ArrayList<>();

    public static void setUserInfo(UserInfoBean userInfo) {
        for(int i=0,size=userCacheList.size(); i<size; i++){
            UserInfoBean bean = userCacheList.get(i);
            if(bean.getId().equals(userInfo.getId())){
                userCacheList.remove(i);
                break;
            }
        }
        userCacheList.add(userInfo);
    }

    public static UserInfoBean getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        for(UserInfoBean bean : userCacheList){
            if(bean.getToken().equals(token)){
                return bean;
            }
        }
       return null;
    }

    public static void removeUserInfoByToken(String token) {
        for(int i=0,size=userCacheList.size(); i<size; i++){
            UserInfoBean bean = userCacheList.get(i);
            if(bean.getToken().equals(token)){
                userCacheList.remove(i);
                break;
            }
        }
    }
}
