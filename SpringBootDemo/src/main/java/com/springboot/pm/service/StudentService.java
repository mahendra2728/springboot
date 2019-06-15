package com.springboot.pm.service;

import java.util.List;

import com.springboot.pm.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student);
	public List<Student> listOfStudents();
	public boolean updateStatus(int id);

}
