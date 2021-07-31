package com.example.the3bits.config;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {

    @GetMapping("/secure")
    public String get() {
        return "OK!!!!!";
    }

    @GetMapping("/admin")
    @Secured("ADMIN")
    public String foo() {
        return "OK!!!!!";
    }
}
