package edu.gmu.spring.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.gmu.spring.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	// define @PostConstruct to load the student .. only once!
	@PostConstruct
	public void loadData() {
		
		students = new ArrayList<>();
		
		// create some sample students.
		// it will be replaced with database later.
		students.add(new Student("Abraham", "Lee"));
		students.add(new Student("David", "Ji"));
		students.add(new Student("Jacob", "Kim"));
	}
	
	// define end-point for "/students" - return list of students.
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		return students;
	}
	
	// define end-point for "/students/{stduentId}" - return student at index.
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// check the studentId against list size.
		if ((studentId >= students.size()) || (studentId <0))
			throw new StudentNotFoundException("student id not found - " + studentId);
		
		// just index into the list .. keep it simple for a while.
		return students.get(studentId);
	} 
	
	// add an exception handler using @ExceptionHandler.
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}