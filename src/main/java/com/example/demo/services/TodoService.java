package com.example.demo.services;

import com.example.demo.models.Todo;
import com.example.demo.repositories.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo findById(long id) {
        Optional<Todo> optional = todoRepository.findById(id);
        return optional.orElse(null);
    }

    public Todo save(Todo todo) {
        log.info(todo.toString());
        return todoRepository.save(todo);
    }

    public Todo markAsDone(long id) {
        Todo todo = findById(id);
        if (todo != null) {
            todo.setCompleted(true);
            return save(todo);
        }

        return null;
    }

    public void delete(Todo todo) {
        todoRepository.delete(todo);
    }

    public void deleteById(long id) {
        todoRepository.deleteById(id);
    }
}
