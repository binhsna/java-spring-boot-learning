package com.binhnc.session01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloworldController {


    //  @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String showHello() {
        return "helloworld";
    }

    @RequestMapping("/hello")
    public String showHello1() {
        return "helloworld";
    }

    @GetMapping("/helloName")
    public String helloName() {
        return "helloworld";
    }

    @GetMapping("/display")
    public String displayName(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("=> " + name);
        request.setAttribute("NAME", name);
        return "display";
    }
}
