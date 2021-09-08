package com.example.the3bits.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {

    @GetMapping("/secure")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public String get() {
        return "OK!!!!!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String foo() {
        return "OK!!!!!";
    }
    
      @GetMapping("/ashot")
    public String ghazaryan() {
        return "Ashot Ghazaryan";
    }
}
