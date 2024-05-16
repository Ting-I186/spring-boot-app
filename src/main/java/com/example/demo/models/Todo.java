package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table(value = "cap\".\"todo")
public class Todo {
    @Id
    private long id;
    private String task;
    private boolean completed;
}
