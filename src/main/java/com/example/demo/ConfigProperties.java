package com.example.demo;

import com.example.demo.models.Person;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties
@Configuration
@Getter
@Setter
public class ConfigProperties {
    private String name = "defaultName";
    private boolean enabled = false;
    private Person person = new Person("defaultName", "defaultSurname");
}
