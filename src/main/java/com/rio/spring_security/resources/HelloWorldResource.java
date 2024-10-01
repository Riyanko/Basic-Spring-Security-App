package com.rio.spring_security.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
	@GetMapping("/hello-world")
	public String HeloWorld() {
		return "Hello World!!";
	}
}
