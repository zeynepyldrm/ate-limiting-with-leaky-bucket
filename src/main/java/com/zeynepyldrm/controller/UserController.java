package com.zeynepyldrm.controller;

import com.zeynepyldrm.annotation.RateLimiting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @RateLimiting
    @PostMapping
    public String handleRequest() {
        return "Request accepted.";
    }
}
