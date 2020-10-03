package com.pm.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.cache.model.User;
import com.pm.cache.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public List<User> users(){
		return userService.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public User userById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		userService.deleteUserById(id);
	}
}
