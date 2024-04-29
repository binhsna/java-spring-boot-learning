package com.company.demo.controller;

import com.company.demo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    public User helloWorld() {
        User user = new User(1, "Nguyễn Công Bình");
        return user;
    }

    @RequestMapping(value = "/hello-two", method = RequestMethod.GET)
    public ResponseEntity<?> helloTwo() {
        User user = new User(1, "Nguyễn Công Bình");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
    }
}
