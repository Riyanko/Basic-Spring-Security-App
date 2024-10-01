package com.rio.spring_security.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	record Todo(String username,String description) {}
	private static final List<Todo> todo=List.of(new Todo("Radha","Learn Spring Boot"),
			new Todo("Madhav","Learn AWS"));
	
	@GetMapping("/todo")
	public List<Todo> ShowTodoList(){
		return todo;
	}
	@GetMapping("/users/{username}/todos")
	public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
		return todo.get(0);
	}

	@PostMapping("/users/{username}/todos")
	public void createTodoForSpecificUser(@PathVariable String username
			, @RequestBody Todo todo) {
		logger.info("Create {} for {}", todo, username);
	}
}
