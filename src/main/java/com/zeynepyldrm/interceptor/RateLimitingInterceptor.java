package com.zeynepyldrm.interceptor;

import com.zeynepyldrm.annotation.RateLimiting;
import com.zeynepyldrm.service.LeakyBucketService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RateLimitingInterceptor implements HandlerInterceptor {

    @Autowired
    LeakyBucketService leakyBucketService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RateLimiting rateLimiting = handlerMethod.getMethodAnnotation(RateLimiting.class);
            if (rateLimiting != null) {
                boolean result = leakyBucketService.addRequestBucket();
                if (!result){
                    response.setStatus(429);
                    response.getWriter().write("Too many requests - please try again later.");
                }
                return result;
            }
        }
        response.setStatus(429);
        response.getWriter().write("Too many requests - please try again later.");
        return false;
    }
}
