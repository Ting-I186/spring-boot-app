package com.example.demo.controllers;

import com.example.demo.models.Todo;
import com.example.demo.services.TodoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

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
    public ResponseEntity<?> save(@RequestBody Todo todo) {
        if (todo.getTask().length() > 255) {
            return new ResponseEntity<>("Task name exceeds character maximum (255).", HttpStatus.BAD_REQUEST);
        } else if (todo.getTask().isEmpty()) {
            return new ResponseEntity<>("Please enter a valid task.", HttpStatus.BAD_REQUEST);
        }
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
    public ResponseEntity<?> delete(@RequestBody Todo todo) {
        if (todo.getId() == 0 || todoService.findById(todo.getId()) == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            todoService.delete(todo);
            return ResponseEntity.ok("Todo deleted successfully.");
        } catch (Exception e) {
            return new ResponseEntity<>("Todo could not be deleted, please try again.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        if (id == 0 || todoService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            todoService.deleteById(id);
            return ResponseEntity.ok("Todo deleted successfully.");
        } catch (Exception e) {
            return new ResponseEntity<>("Todo could not be deleted, please try again.", HttpStatus.BAD_REQUEST);
        }
    }
}
