package com.alpha.core.config;

import com.alpha.core.constant.ConfigConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
        System.out.println("---------order 1 -----执行过滤操作------------");

        // 防止流读取一次后就没有了, 所以需要将流继续写出去

        String contentType =  servletRequest.getContentType(); //请求类型
        if(ConfigConstant.accpetType.contains(contentType)){
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            servletRequest = new JsonReaderHttpServletRequestWrapper(httpServletRequest);
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        log.info("--------order 1 ------过滤器销毁------------");
    }
}