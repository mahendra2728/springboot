package com.sp.util;

import java.util.Arrays;
import java.util.List;

import com.sp.model.Student;

import rx.Observable;

public class ReactiveExample {

	List<Student> students=Arrays.asList(new Student(1,"Mahendra","Maske","m@gmail.com"),
			new Student(2,"Roman","Reign","r@gmail.com"),new Student(3,"Seth","Rollins","s@gmail.com"));
	
	public static void main(String[] args) {
		
		Observable<Student> observable = new ReactiveExample().getStudents();
		observable.subscribe(System.out::println, throwable -> System.out.println(throwable.getMessage()),
				() -> System.out.println("completed"));
	}
	
	public Observable<Student> getStudents() {
		return Observable.create(subscriber -> {
			if (!subscriber.isUnsubscribed()) {
				students.stream().forEach(employee -> {
					subscriber.onNext(employee);
					// forcefully raising exception
					//subscriber.onError(new RuntimeException("Exception Raised"));

				});
			}
			subscriber.onCompleted();
		});
	}

}
