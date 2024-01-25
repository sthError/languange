package com.hape.common.interceptor;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在处理请求之前打印请求参数
        String uri = request.getRequestURI();
        String channel = request.getHeader("channel");
        String token = request.getHeader("token");
        log.info("base request info ======> uri:{}, channel:{}, token:{}, request param:{} ", uri, channel, token, JSONUtil.toJsonStr(request.getParameterMap()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在处理完请求之后打印响应结果
//        System.out.println("Response Status: " + response.getStatus());
        String uri = request.getRequestURI();
        String channel = request.getHeader("channel");
        String token = request.getHeader("token");
//        getResponseBody(response);
//        log.info("base response ======> uri:{}, channel:{}, token:{}, response param:{} ", uri, channel, token, JSONUtil.toJsonStr(response.getParameterMap()));
    }

//    private String getResponseBody(HttpServletResponse response) throws IOException {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.ge()))) {
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                stringBuilder.append(line);
//            }
//            return stringBuilder.toString();
//        }
//    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在视图渲染完成后执行，可用于资源清理等操作
    }
}
