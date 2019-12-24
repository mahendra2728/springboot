package com.pm.springboot.curd.springbootcurd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pm.springboot.curd.springbootcurd.entity.StudentNotFoundError;

@ControllerAdvice
public class StudentNotFoundHandle {

	@ExceptionHandler
	public ResponseEntity<StudentNotFoundError> studentNotFound(StudentNotFoundException err)
	{
		StudentNotFoundError error=new StudentNotFoundError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(err.getMessage());
		error.setCurrenttime(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentNotFoundError> studentException(Exception err)
	{
		StudentNotFoundError error=new StudentNotFoundError();
		error.setStatus(HttpStatus.BAD_GATEWAY.value());
		error.setMessage(err.getMessage());
		error.setCurrenttime(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_GATEWAY);
	}
	
}
	
