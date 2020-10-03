package com.pm.es.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pm.es.model.Student;
import com.pm.es.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository repository;
	
	
	@PostMapping("/students")
	public ResponseEntity<Object> addStudent(@RequestBody Student student){
		Student response=repository.save(student);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	
	@PostMapping("/bulkInsert")
	public ResponseEntity<Object> addStudent(@RequestBody List<Student> student){
		Iterable<Student> response=repository.saveAll(student);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<Object> getStudents(){
		//List<Student> response=repository.findAll();
		return new ResponseEntity<Object>(repository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/student/{firstName}")
	public ResponseEntity<Object> getStudents(@PathVariable String firstName){
		return new ResponseEntity<Object>(repository.findByFirstName(firstName), HttpStatus.OK);	
	}
	
	
}
