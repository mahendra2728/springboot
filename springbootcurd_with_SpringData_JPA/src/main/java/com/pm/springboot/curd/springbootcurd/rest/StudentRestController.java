package com.pm.springboot.curd.springbootcurd.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.springboot.curd.springbootcurd.entity.Student;
import com.pm.springboot.curd.springbootcurd.exception.StudentNotFoundException;
import com.pm.springboot.curd.springbootcurd.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	//create Service object reference
	private StudentService studentService;
	
	//inject service object using contructor injection
	public StudentRestController(StudentService theStudentService) {
		studentService=theStudentService;
	}
	
	//get All students
	@GetMapping("/employees")
	public List<Student> getAllStudent()
	{
		return studentService.findAll();
	}
	
	//get Single student based on Id
	@GetMapping("/employees/{theStudentId}")
	public Student getStudent(@PathVariable int theStudentId)
	{
		Student student=studentService.getStudent(theStudentId);
		if(student==null)
		{
			throw new StudentNotFoundException("Student Id "+theStudentId+" Not Found");
		}
		return student;
	}
	
	//Add new Student
	@PostMapping("/employees")
	public Student addStudent(@RequestBody Student theStudent)
	{
		theStudent.setId(0);
		studentService.save(theStudent);
		return theStudent;
	}
	
	//Update student
	@PutMapping("/employees")
	public Student updateStudent(@RequestBody Student theStudent)
	{
		studentService.save(theStudent);
		return theStudent;
	}
	
	//Delete student
	@DeleteMapping("/employees/{theStudentId}")
	public String deleteStudent(@PathVariable int theStudentId)
	{
		Student student=studentService.getStudent(theStudentId);
		if(student==null)
		{
			throw new StudentNotFoundException("Student Id not Exist");
		}
		studentService.deleteStudent(theStudentId);
		return "Student Id "+theStudentId+" Deleted successfully...";
	}
	

}









