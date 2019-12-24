package com.pm.springboot.curd.springbootcurd.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.springboot.curd.springbootcurd.entity.Student;

/*@RepositoryRestResource(path="employees")*/
public interface StudentDAOJpa extends JpaRepository<Student, Integer> {

}
