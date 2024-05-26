package com.zeynepyldrm.controller;

import com.zeynepyldrm.annotation.RateLimiting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class UserController {

    @RateLimiting
    public String handleRequest(@RequestParam(defaultValue = "1") int amount) {
        boolean allowed = true;
        if (allowed) {
            return "Request accepted.";
        } else {
            return "Request rejected - too many requests.";
        }
    }
}
