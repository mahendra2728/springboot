package com.pm.springboot.curd.springbootcurd.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.springboot.curd.springbootcurd.entity.Student;

public interface StudentDAOJpa extends JpaRepository<Student, Integer> {

}
