package com.example.tacocloud.controller;

import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Home";
    }
}
