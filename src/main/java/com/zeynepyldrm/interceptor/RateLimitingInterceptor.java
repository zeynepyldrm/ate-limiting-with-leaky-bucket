package com.zeynepyldrm.interceptor;

import com.zeynepyldrm.annotation.RateLimiting;
import com.zeynepyldrm.service.LeakyBucketService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;

@Component
public class RateLimitingInterceptor implements HandlerInterceptor {

    @Autowired
    LeakyBucketService leakyBucketService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod maControl = (HandlerMethod) handler;
            Method pmrResolver = (Method) maControl.getMethod();
            String methodName = pmrResolver.getName();
            // ...
            RateLimiting rateLimiting = maControl.getMethodAnnotation(RateLimiting.class);
            if (rateLimiting != null) {
                leakyBucketService.addRequestBucket();
            }
        }
        return true;
    }
}
