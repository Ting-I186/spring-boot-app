package com.example.demo.controllers;

import com.example.demo.ConfigProperties;
import com.example.demo.models.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
public class PropertiesController {
    private final ConfigProperties configProperties;

    public PropertiesController(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @GetMapping("/name")
    public String getName() {
        return configProperties.getName();
    }

    @GetMapping("/enabled")
    public boolean isEnabled() {
        return configProperties.isEnabled();
    }

    @GetMapping("person")
    public Person getPerson() {
        return configProperties.getPerson();
    }
}
