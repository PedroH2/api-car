package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;
	
	@NotNull
	private Double saldoemconta;
	
	@NotNull
	private Integer idade;
	
	@NotNull
	private String cpf;
	
	@NotNull
	@Email
	private String email;
}
