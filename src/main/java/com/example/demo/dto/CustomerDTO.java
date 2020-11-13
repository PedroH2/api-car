package com.example.demo.dto;

import com.example.demo.model.Customer;

import lombok.Data;

@Data
public class CustomerDTO {
	private Long id;
	private String nome;
	private Double saldoemconta;
	private Integer idade;
	private String cpf;
	private String email;
	
	public Customer cliente() {
		Customer cust = new Customer();
		
		cust.setId(this.id);
		cust.setNome(this.nome);
		cust.setSaldoemconta(this.saldoemconta);
		cust.setIdade(this.idade);
		cust.setCpf(this.cpf);
		cust.setEmail(this.email);
		
		return cust;
	}
}
