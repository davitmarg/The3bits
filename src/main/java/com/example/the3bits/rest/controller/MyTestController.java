package com.example.the3bits.rest.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

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
}
