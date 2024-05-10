package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {
    @GetMapping("/")
    public String index() {
        log.info("Hello world endpoint requested.");
        return "Hello world!";
    }
}
