package com.hape.common.aspect;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Aspect
@Component
public class LogAspect {

    private static ThreadLocal<Long> timeStamp = new ThreadLocal<>();

    /**
     * 环绕通知
     */
    @Around("execution(* com.hape.controller..api.*(..))")
    public Object logPrint(ProceedingJoinPoint point) throws Throwable {
        timeStamp.set(System.currentTimeMillis());
        String sequence = IdUtil.simpleUUID();
        ServletRequestAttributes context = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = context.getRequest();
        String token = request.getHeader("token");
        Object[] args = point.getArgs();
        // 构造参数组集合
        List<Object> argList = new ArrayList<>();
        for (Object obj : args) {
            if (obj instanceof HttpServletRequest) {
                argList.add("request");
            } else if (obj instanceof HttpServletResponse) {
                argList.add("response");
            } else if (obj instanceof MultipartFile) {
                argList.add("file");
            } else {
                argList.add(obj);
            }
        }
        log.info("流水号:{},token:{}, 请求路径:{},请求参数:{}", sequence, token, request.getRequestURI(), JSONUtil.toJsonStr(argList));
        Object proceed = point.proceed();
        log.info("流水号:{}, 请求响应:{} 耗时:{}", sequence, JSONUtil.toJsonStr(proceed), System.currentTimeMillis() - timeStamp.get());
        return proceed;
    }
}
