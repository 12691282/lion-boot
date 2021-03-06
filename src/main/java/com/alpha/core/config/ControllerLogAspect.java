package com.alpha.core.config;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * aop controller 层日志 
 * @author lion
 *
 */

@Aspect
@Component
@Slf4j
public class ControllerLogAspect {

    ThreadLocal<Instant> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.alpha.module.*.controller.*.*(..))")
    public void webLog(){
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(Instant.now());// 开始时间

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("URL : {}", request.getRequestURL().toString());
        log.info("HTTP_METHOD : {}", request.getMethod());
        log.info("IP : {}", request.getRemoteAddr());
        log.info("CLASS_METHOD : {}.{}", joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        log.info("ARGS : {}", joinPoint.getArgs());
        
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret){
        Instant end = Instant.now();//结束时间
        long time = Duration.between(startTime.get(), end).toMillis();// 时间段差
        // 处理完请求，返回内容
        log.info("RESPONSE : {}" , ret);
        log.info("SPEND TIME : {}毫秒",time);
    }
}
