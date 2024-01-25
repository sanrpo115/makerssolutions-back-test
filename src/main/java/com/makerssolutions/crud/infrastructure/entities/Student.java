package com.makerssolutions.crud.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Pattern(regexp = "^[a-zA-Z]+$", message = "El campo debe contener solo letras")
	@NotBlank(message = "El campo nombre es obligatorio")
    private String firstname;
	@Pattern(regexp = "^[a-zA-Z]+$", message = "El campo debe contener solo letras")
	@NotBlank(message = "El campo apellido es obligatorio")
    private String lastname;
    @Column(unique = true)
    @NotBlank(message = "El campo email es obligatorio")
    private String email;

}
