package com.example.tacocloud;

import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Home";
    }
}
