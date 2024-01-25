package com.makerssolutions.crud.application.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.makerssolutions.crud.infrastructure.entities.Student;
import com.makerssolutions.crud.infrastructure.repositories.StudentRepository;

@Service
public class StudentService {
	
	HashMap<String, Object> map;
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() {
		return this.studentRepository.findAll();
	}

	public ResponseEntity<Object> createStudent(Student student) {
		try {			
			Optional<Student> res = studentRepository.findStudentByEmail(student.getEmail());
			map = new HashMap<>();
			
			if (res.isPresent()) {
				map.put("error", true);
				map.put("message", "El estudiante ya existe");
				return  new ResponseEntity<>(map, HttpStatus.CONFLICT);
			}
			
			studentRepository.save(student);
			map.put("data", student);
			map.put("message", "Se ha creado el estudiante correctamente");
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (Exception e) {
			map.put("error", true);
			map.put("message", e.getMessage());
			return  new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Object> updateStudent(Student student) {
		try {			
			Optional<Student> res = studentRepository.findById(student.getId());
			map = new HashMap<>();
			
			if (res.isEmpty()) {
				map.put("error", true);
				map.put("message", "El estudiante no existe");
				return  new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
			}
			
			studentRepository.save(student);
			map.put("data", student);
			map.put("message", "Se ha actualizado correctamente el registro");
			return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			map.put("error", true);
			map.put("message", e.getMessage());
			return  new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
		
	};
	
	public ResponseEntity<Object> deleteStudent(Long id) {
		boolean exists = this.studentRepository.existsById(id);
		map = new HashMap<>();
		
		if(!exists) {
			map.put("error", true);
			map.put("message", "No existe un registro con ese ID");
			return  new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
		
		studentRepository.deleteById(id);
		map.put("message", "Registro eliminado exitosamente");
		return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
	}

}
