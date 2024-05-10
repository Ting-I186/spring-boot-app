package com.example.demo;

import com.example.demo.models.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties
@Configuration
public class ConfigProperties {
    private String name = "defaultName";
    private boolean enabled = false;
    private Person person = new Person();

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Person getPerson() {
        return person;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
