package com.example.demo.dto;

import com.example.demo.model.Car;

import lombok.Data;

@Data
public class CarDTO {

	private Long id;
	private String modelo;
	private Integer ano;
	private String tipo;
	private String marca;
	private double valor;
	private String aroRoda;	
	private Integer qtdEstoque;
	
	public Car carro() {
		Car carro = new Car();
		carro.setId(this.id);
		carro.setModelo(this.modelo);
		carro.setAno(this.ano);
		carro.setTipo(this.tipo);
		carro.setMarca(this.marca);
		carro.setValor(this.valor);
		carro.setAroRoda(this.aroRoda);
		carro.setQtdEstoque(this.qtdEstoque);
		return carro;
	}
}
