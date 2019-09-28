package com.alpha.core.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alpha.core.constant.ConfigConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 传入参数拦截
 */
@Slf4j
public class ApiParameterInterceptor  extends HandlerInterceptorAdapter {


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
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(" ...Interceptor.. ");

        String contentType =  request.getContentType(); //请求类型
        if(ConfigConstant.accpetType.contains(contentType)){
            JsonReaderHttpServletRequestWrapper  wrapper = new JsonReaderHttpServletRequestWrapper(request);
            JSONObject parameterMap = JSON.parseObject(wrapper.toBodyString());

            Object size = parameterMap.getString("size");
            Object index = parameterMap.getString("index");
        }


        String method = request.getMethod();     //请求方式
        String protocol = request.getProtocol();   //请求http协议版本

        System.out.println(ConfigConstant.accpetType.contains(contentType));
        String path = request.getServletPath();
        Map paramMap = request.getParameterMap();


        return true;
    }

}
