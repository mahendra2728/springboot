package com.pm.springboot.curd.springbootcurd.service;

import java.util.List;

import com.pm.springboot.curd.springbootcurd.entity.Student;

public interface StudentService {

    public List<Student> findAll();
	
	public Student getStudent(int theStudentId);
	
	public void save(Student student);
	
	public void deleteStudent(int theStudentId);
}
