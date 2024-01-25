package com.hape.common.interceptor;

import com.alibaba.fastjson2.JSON;
import com.hape.common.annotation.BackLoginIgnore;
import com.hape.common.enums.TokenEnum;
import com.hape.common.exception.BusinessException;
import com.hape.common.response.R;
import com.hape.common.utils.RedisUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 登录拦截器
 *
 * @Author: hape
 * @Date: 2023/2/20 16:53
 */
@Slf4j
@ApiOperation("个人端登录拦截器")
public class LoginBackInterceptor implements HandlerInterceptor {

    private RedisUtil redisUtil;

    public LoginBackInterceptor(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    @Transactional
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 不是访问方法直接放行
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断方法上或者类是否有登录注解
        String authToken = request.getHeader(TokenEnum.back_token.getCode());
        if (method.getAnnotation(BackLoginIgnore.class) != null ||
                handlerMethod.getBeanType().getAnnotation(BackLoginIgnore.class) != null) {
            return true;
        } else {
            if (StringUtils.isEmpty(authToken)) {
                R result = R.fail("203", "无权访问");
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().print(JSON.toJSONString(result));
                return false;
            } else {
                String cache = redisUtil.get(authToken);
                if (StringUtils.isEmpty(cache)) {
                    throw new BusinessException("未登录或已过期");
                }
                return true;
            }
        }
    }
}
