package com.alpha.core.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alpha.core.constant.ConfigConstant;
import com.alpha.core.tools.ThreadLocalTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@WebFilter(urlPatterns = "/*")
@Order(1)
public class JsonParamsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("----------order 1 ----过滤器初始化------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("---------order 1 -----执行过滤操作------------");

        // 防止流读取一次后就没有了, 所以需要将流继续写出去

        String contentType =  servletRequest.getContentType(); //请求类型
        if(contentType != null && contentType.contains(ConfigConstant.accpetType)){
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            JsonReaderHttpServletRequestWrapper wrapper =  new JsonReaderHttpServletRequestWrapper(httpServletRequest);
            try {
                JSONObject parameterMap = JSON.parseObject(wrapper.toBodyString());
                Object size = parameterMap.getString("size");
                Object index = parameterMap.getString("index");
                if(size != null && index != null){
                    Map pageMap = new HashMap<>();
                    pageMap.put("size", Integer.valueOf(size.toString()));
                    pageMap.put("index",  Integer.valueOf(index.toString()));
                    ThreadLocalTools.getPageMap().set(pageMap);
                }
            }catch (JSONException e){
                log.info("can not change json obj");
            }
            servletRequest =  wrapper;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("--------order 1 ------过滤器销毁------------");
    }
}
