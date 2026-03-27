package com.brigelabz.spring_greeting_app;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        return "App is working";
    }
}