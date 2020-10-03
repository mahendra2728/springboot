package com.pm.cache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pm.cache.model.User;
import com.pm.cache.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Cacheable(cacheNames = { "userCache" })
	public List<User> getUsers(){
		System.out.println("calling getUsers from database");
		return userRepository.findAll();
	}
	
	@Cacheable(value = "userCache", key = "#id", unless = "#result==null")
	public User getUserById(int id) {
		System.out.println("calling getUserById from database");
		return userRepository.findById(id).orElse(null);
	}
	
	@CacheEvict(value = "userCache")
	public void deleteUserById(int id) {
		System.out.println("calling deleteUserById from database");
		userRepository.deleteById(id);
	}
}
