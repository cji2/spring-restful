package edu.gmu.spring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.gmu.spring.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// define end-point for "/students" - return list of students.
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		
		// create some sample students.
		// it will be replaced with database later.
		students.add(new Student("Abraham", "Lee"));
		students.add(new Student("David", "Ji"));
		students.add(new Student("Jacob", "Kim"));
		
		return students;
	}
}
