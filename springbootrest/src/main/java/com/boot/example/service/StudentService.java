package com.boot.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boot.example.entity.Student;

@Service (value = "studentService")
public class StudentService {
	
	public List<Student> students = Arrays.asList(
			new Student("101","Dipakmm", 25, "B101"),
			new Student("102","Ashok", 23, "B102"),
			new Student("103","Rupakk", 21, "B103")
			);

	public List<Student> getStudentList(){
		// Get Data from Database using spring jdbc
		return students;
		
	}

	public Student getStudent(String id) {
		return students.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addStudent(Student student) {
		students.add(student);
	}
}
