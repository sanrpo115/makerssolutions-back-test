package com.makerssolutions.crud.application.usecases;

import java.util.List;

import com.makerssolutions.crud.infrastructure.entities.Student;

public interface StudentUseCase {
	
	List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);

}
