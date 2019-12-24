package com.pm.springboot.curd.springbootcurd.service;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pm.springboot.curd.springbootcurd.dao.StudentDAOJpa;
import com.pm.springboot.curd.springbootcurd.entity.Student;
import com.pm.springboot.curd.springbootcurd.exception.StudentNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAOJpa studentDAOJpa;
	
	public StudentServiceImpl(StudentDAOJpa thestudentDAOJpa) {
		studentDAOJpa = thestudentDAOJpa;
	}
	
	
	@Override
	public List<Student> findAll() {
		return studentDAOJpa.findAll();
	}

	@Override
	public Student getStudent(int theStudentId) {
		
		Optional<Student> result=studentDAOJpa.findById(theStudentId);
		Student student=null;
		if(result.isPresent()) {
			student=result.get();
		}else {
			throw new StudentNotFoundException("Student ID "+theStudentId+" not found");
		}
		return student;
	}

	@Override
	public void save(Student student) {
		studentDAOJpa.save(student);
	}

	@Override
	public void deleteStudent(int theStudentId) {
		studentDAOJpa.deleteById(theStudentId);
	}

}
