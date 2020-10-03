package com.pm.reactive.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.reactive.model.Student;

import reactor.core.publisher.Flux;

@RestController
public class TestController {

	@GetMapping(value="/test1",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Integer> flux(){
	  return Flux.just(1,2,3,4,5,6)
	      .delayElements(Duration.ofSeconds(1))
	      .log();
	}
	
	@GetMapping(value="/test2",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Student> fluxStream(){
		
	//List<Student> studentList=Arrays.asList(new Student(1,"Roman","Reign"),new Student(2,"Dean","Ambrose"),new Student(3,"Brock","Lesner"));
		
	Flux<Student> students=Flux.just(new Student(1,"Roman","Reign"),new Student(2,"Dean","Ambrose"),new Student(3,"Brock","Lesner"))
	      .delayElements(Duration.ofSeconds(3))
	      .log();
	
		return students;
	}
}
