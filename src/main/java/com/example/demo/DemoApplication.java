package com.example.demo;

import com.example.demo.models.Todo;
import com.example.demo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final TodoRepository todoRepository;

	@Autowired
	public DemoApplication(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Todo> optionalTodo = todoRepository.findById(1L);
		if (optionalTodo.isPresent()) {
			Todo todo = optionalTodo.get();
			System.out.println(todo);
			todo.setCompleted(true);
			Todo savedTodo = todoRepository.save(todo);
			System.out.println(savedTodo);
		}
	}
}
