package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.CustomerBusiness;
import com.example.demo.model.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerBusiness customerBusiness;
	
	public List<Customer> findAll() {
		return customerBusiness.findAll();
	}

	public void save(Customer cust) {
		customerBusiness.save(cust);
	}

	public Customer findById(Long id) {
		return customerBusiness.findById(id);
	}

	public Customer update(@Valid Customer cust) {
		return customerBusiness.update(cust);
		
	}

	public List<Customer> findByNome(String nome) {
		return customerBusiness.findByNome(nome);
	}

	public void delete(@Valid Long id) {
		customerBusiness.delete(id);		
	}

}
