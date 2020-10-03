package com.pm.es.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pm.es.dao.StudentDAO;
import com.pm.es.model.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentDAO studentDao;
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student response=studentDao.insertStudent(student);
		if(response==null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
	return new ResponseEntity<Student>(response,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Object> getStudents(@PathVariable String id){
		Map<String, Object> students=studentDao.getStudents(id);
		return new ResponseEntity<Object>(students,HttpStatus.OK);
	}
}
