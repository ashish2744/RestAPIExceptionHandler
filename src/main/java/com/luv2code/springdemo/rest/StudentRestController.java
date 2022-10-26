package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;
import com.luv2code.springdemo.rest.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	@PostConstruct
	public void loadData() {
		students = new ArrayList<Student>();
		students.add(new Student("Ashish","Tiwari"));
		students.add(new Student("Manish","Aggarwal"));
		students.add(new Student("Aman","Sharma"));
		students.add(new Student("Ajay","Shukla"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		if((studentId>=students.size())||(studentId<0)) {
			throw new StudentNotFoundException("Student id not found-"+studentId);
		}
		return students.get(studentId);
	}
	
}
