package com.pm.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import com.pm.es.model.Student;

@SuppressWarnings("deprecation")
@Repository
public interface StudentRepository extends ElasticsearchCrudRepository<Student,Integer>{

	List<Student> findByFirstName(String firstName);

}
