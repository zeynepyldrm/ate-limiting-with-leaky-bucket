package com.zeynepyldrm.interceptor;

import com.zeynepyldrm.annotation.RateLimiting;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class RateLimitingInterceptor implements HandlerInterceptor {

    private HandlerMethod method;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        method = (HandlerMethod) handler;
        RateLimiting rateLimiting = method.getMethodAnnotation(RateLimiting.class);
        if (rateLimiting != null) {
            if (request.getRequestURI().endsWith("/user")) {

            }
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
