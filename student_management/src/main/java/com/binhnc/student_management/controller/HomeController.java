package com.binhnc.student_management.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHomepage() {
        return "index";
    }

    @RequestMapping("/login")
    public String logout() {
        return "login";
    }
}
