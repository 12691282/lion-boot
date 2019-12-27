package com.alpha.core.config;

import com.alibaba.fastjson.JSON;
import com.alpha.core.tools.ResultObject;
import com.alpha.core.tools.UserInfoTool;
import com.alpha.module.system.bean.UserInfoBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * token 参数拦截，验证
 */
@Slf4j
public class TokenParameterInterceptor extends HandlerInterceptorAdapter {


    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     * 基于URL实现的拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception  {
        Object token = request.getHeader("token");
        log.info(" ===》》》》》》Interceptor..token: {} handler:{}",token,handler);
        if(token == null){
            this.setErrorMessage(response);
            return false;
        }
        UserInfoBean userInfo =  UserInfoTool.getUserInfo(request);
        if(userInfo == null){
            this.setErrorMessage(response);
            return false;
        }
        //是否过期
        if(userInfo.isTimeOut()){
            this.setErrorMessage(response);
            return false;
        }
        return true;
    }

    private void setErrorMessage(HttpServletResponse response) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            String json = JSON.toJSON(ResultObject.getFailure("500", "invalid token")).toString();
            response.setStatus(200);
            writer.print(json);
        } catch (IOException e){
            log.info(e.getMessage());
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }

}
