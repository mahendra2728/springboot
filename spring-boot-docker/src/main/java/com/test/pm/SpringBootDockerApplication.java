package com.test.pm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

	@GetMapping("/")
	public String print() {
		return "Welcome To My First Docker Image";
	}
	
	@GetMapping("/api/{name}")
	public String  print2(@PathVariable String name) {
		return "Hi "+name+" Welcome to Docker Hub";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

}
