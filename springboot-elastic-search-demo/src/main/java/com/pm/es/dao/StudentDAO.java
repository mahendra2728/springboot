package com.pm.es.dao;

import java.util.Map;

import com.pm.es.model.Student;

public interface StudentDAO {

	public Student insertStudent (Student student);
	public Map<String, Object> getStudents(String id);
}
