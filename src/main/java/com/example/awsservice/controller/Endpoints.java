package com.example.awsservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Endpoints {

    @GetMapping("/hello")
    public String init() {
        return "Hello World";
    }
}
