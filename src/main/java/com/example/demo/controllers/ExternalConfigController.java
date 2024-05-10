package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external")
public class ExternalConfigController {
    @Value("${user.role}")
    private String role;

    @GetMapping("/whoami/{username}")
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello! You're %s and you are a(n) %s...\n", username, role);
    }
}
