package com.boot.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.example.entity.Student;
import com.boot.example.service.StudentService;


//Run project with 'Spring Boot App'
//Test the api working :: try with http://localhost:8080/students/103 in post man
//In chrome run http://localhost:8080/swagger-ui.html -> Expand operations -> Try it out

@RestController
public class StudentResourse {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("students")
	public List<Student> getStudents(){
		return studentService.getStudentList();
	}
	
	@GetMapping("students/{id}") 
	//@RequestMapping(method=RequestMethod.GET, value="students/{id}")
	public Student getSingleStudent(@PathVariable String id){
		return studentService.getStudent(id);
	}
	
	@PostMapping(path="/students", consumes = "application/json")
	//@RequestMapping(value = "/students", method = RequestMethod.POST)
	public void addStudent(@RequestBody Student student){
		studentService.addStudent(student);
	}
	
}
