package com.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sp.model.Student;

@Mapper
public interface StudentMapper {

	
	public List<Student> getAll();
	public Student getById(int id);
	public Student getByIdStoreProcedure(Student student);
	
	public void insertStudent(Student student);
	
	
}
