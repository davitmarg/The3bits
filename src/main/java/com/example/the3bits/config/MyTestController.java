package com.example.the3bits.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {

    @GetMapping("/secure")
    public String get() {
        return "OK!!!!!";
    }
}
