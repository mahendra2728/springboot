package com.pm.es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "student-index",type="student",replicas = 2)
public class Student {

	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	
}
