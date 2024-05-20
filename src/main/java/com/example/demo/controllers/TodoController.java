package com.example.demo.controllers;

import com.example.demo.models.Todo;
import com.example.demo.services.TodoService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable long id) {
        Todo todo = todoService.findById(id);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Todo> save(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.save(todo));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Todo> markAsDone(@PathVariable long id) {
        Todo todo = todoService.markAsDone(id);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public void delete(@RequestBody Todo todo) {
        todoService.delete(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        todoService.deleteById(id);
    }
}
