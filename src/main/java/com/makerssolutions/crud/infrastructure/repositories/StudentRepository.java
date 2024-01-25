package com.makerssolutions.crud.infrastructure.repositories;

import com.makerssolutions.crud.infrastructure.entities.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Optional<Student> findStudentByEmail(String email);
}
