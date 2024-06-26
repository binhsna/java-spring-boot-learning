package com.binhnc.demosession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping
    public String showHomePage() {
        return "index";
    }

    @GetMapping("login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("register")
    public String showRegisterForm() {
        return "register";
    }
}
