package com.makerssolutions.crud.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makerssolutions.crud.application.services.StudentService;
import com.makerssolutions.crud.infrastructure.entities.Student;

import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	};
	
	@GetMapping
	public List<Student> getStudents() {
		return this.studentService.getStudents();
	};
	
	@PostMapping
	public ResponseEntity<Object> createStudent(@RequestBody @Valid Student student) {
		return this.studentService.createStudent(student);
	};
	
	@PutMapping
	public ResponseEntity<Object> updateStudent(@RequestBody @Valid Student student) {
		return this.studentService.updateStudent(student);
	};
	
	@DeleteMapping(path = "{studentId}")
	public ResponseEntity<Object> deleteStudent(@PathVariable("studentId") Long id) {
		return this.studentService.deleteStudent(id);
	};
}
