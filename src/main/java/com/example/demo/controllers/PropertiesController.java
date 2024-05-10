package com.example.demo.controllers;

import com.example.demo.ConfigProperties;
import com.example.demo.models.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/properties")
public class PropertiesController {
    private final ConfigProperties configProperties;

    public PropertiesController(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @GetMapping("/name")
    public String getName() {
        log.info("Get name endpoint requested.");
        return configProperties.getName();
    }

    @GetMapping("/enabled")
    public boolean isEnabled() {
        log.info("Is Enabled endpoint requested.");
        return configProperties.isEnabled();
    }

    @GetMapping("person")
    public Person getPerson() {
        log.info("Get person endpoint requested.");
        return configProperties.getPerson();
    }
}
