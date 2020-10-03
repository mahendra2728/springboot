package com.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.mapper.StudentMapper;
import com.sp.model.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentMapper mapper;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return mapper.getAll();
	}
	
	@PostMapping("/studentsInsert")
	public Student getStudents(@RequestBody Student student){
		System.out.println("id > "+student.toString());
		return mapper.getByIdStoreProcedure(student);
	}
	
	@PostMapping("/students")
	public void addStudent(@RequestBody Student student){
		System.out.println(student.getFirstName());
		mapper.insertStudent(student);
	}
}
