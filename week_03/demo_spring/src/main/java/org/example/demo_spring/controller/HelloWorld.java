package org.example.demo_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @Autowired
    private String avc;
    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }
}
