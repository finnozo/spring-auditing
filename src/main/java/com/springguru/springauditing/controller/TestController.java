package com.springguru.springauditing.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/showMyLoginPage")
    public String showLoginPage() {

        // return "plain-login";
        return "fancy-login";
    }
    @GetMapping("/test")
    public String start(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.err.println(authentication);
        return "index";
    }
}
