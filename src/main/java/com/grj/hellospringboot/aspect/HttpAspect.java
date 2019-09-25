package com.grj.hellospringboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description aop处理请求
 * @Author guorenjie
 * @Date 2019/9/23 18:30
 **/
@Aspect
@Component
public class HttpAspect {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.grj.hellospringboot.controller.*.*(..))")
    public void log() {

    }

    /**
     * 记录http请求
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.debug("url={}", request.getRequestURL());
        log.debug("method={}", request.getMethod());
        log.debug("ip={}", request.getRemoteAddr());
        log.debug("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.debug("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        log.debug("after...");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("response={}", object);
    }

}
