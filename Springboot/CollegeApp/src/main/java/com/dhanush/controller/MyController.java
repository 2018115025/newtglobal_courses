package com.dhanush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dhanush.entity.Student;
import com.dhanush.service.StudentService;


@RestController
public class MyController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/hi")
	public String sayHello() {
		return "hello";
	}
	
	
	@PostMapping("/addstudent")
	public Student addStudentHandler(@RequestBody Student s) throws Exception {
		System.out.println(s.getName());
		return studentService.addStudent(s);
	}

}
