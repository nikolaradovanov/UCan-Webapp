package com.ovdebeli.ucan.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "/auth/login";
    }

    @GetMapping("/")
    public String home() {
        return "/index";
    }
}
