package com.springboot.pm.restcontroller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.pm.SpringBootDemo.SpringBootDemoApplication;
import com.springboot.pm.model.Student;
import com.springboot.pm.service.StudentService;

@RestController
@RequestMapping("/mm")
public class MyRestController {
	private static final Logger logger = LoggerFactory.getLogger(MyRestController.class);
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/")
	public ModelAndView setHome()
	{
		ModelAndView mv=new ModelAndView();
	//	List<Student> students=studentService.listOfStudents();
		mv.addObject("message","Welcome Mahendra...");
		mv.addObject("students",studentService.listOfStudents());
		mv.setViewName("home");
		return mv;
	}
	
	@CrossOrigin(origins = "https://localhost:4200")
	@RequestMapping(value="/getStudent",method=RequestMethod.GET)
	public ResponseEntity<Object> getStudent() throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		
		List<Student> students=studentService.listOfStudents();
		
		logger.debug("In GET student API "+students);
		if(students==null)
		{
			return new ResponseEntity<Object>(students,headers, HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<Object>(students, headers,HttpStatus.OK);
		}
		
	}
	
	@CrossOrigin(origins = "https://localhost:4200")
	@RequestMapping(value="/addStudent",method=RequestMethod.POST)
	public ResponseEntity<Object> addStudent(@RequestBody Student student,BindingResult resultStudent)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		Student student1=null;
		if(!resultStudent.hasErrors()){
			student1=studentService.addStudent(student);
	       }
		
		if(student1==null)
		{
			return new ResponseEntity<Object>("BAD DATA", headers,HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<Object>(student1,headers,HttpStatus.OK);
		}
	}
	@CrossOrigin(origins = "https://localhost:4200")
	@RequestMapping(value="/updateStatus",method=RequestMethod.POST)
	public ResponseEntity<Object> updateStatus(@RequestBody int id,BindingResult resultStudent)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		
		boolean student=false;
		if(!resultStudent.hasErrors()){
			student=studentService.updateStatus(id);
	       }
		
		if(!student)
		{
			return new ResponseEntity<Object>("BAD DATA",headers ,HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<Object>("Updated successfully",headers,HttpStatus.OK);
		}
	}

}
