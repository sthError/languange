package com.hape.common.config;

import com.hape.common.interceptor.LoginBackInterceptor;
import com.hape.common.interceptor.LoginFrontInterceptor;
import com.hape.common.utils.RedisUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private RedisUtil redisUtil;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册登录拦截器
        registry.addInterceptor(new LoginFrontInterceptor(redisUtil)).addPathPatterns("/front/**");
        registry.addInterceptor(new LoginBackInterceptor(redisUtil)).addPathPatterns("/back/**");
    }
}
