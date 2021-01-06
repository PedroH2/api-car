package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String modelo;
	
	@NotNull
	private Integer ano;
	
	@NotNull
	private String tipo;
	
	@NotNull
	private String marca;
	
	@NotNull
	private double valor;
	
	@NotNull
	private String aroRoda;	
	
	@NotNull
	private Integer qtdEstoque;

}
