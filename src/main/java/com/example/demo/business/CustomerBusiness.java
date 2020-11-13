package com.example.demo.business;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Component
public class CustomerBusiness {

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public void save(Customer cust) {
		if (cust == null)
			throw new RuntimeException("Cliente não pode ser nulo");
		customerRepository.save(cust);
	}

	public Customer findById(long id) {
		Customer cust = customerRepository.findById(id);
		if (cust == null)
			throw new ResourceNotFoundException("Cliente Não encontrado");

		return cust;
	}

	public Customer update(@Valid Customer cust) {
		if (customerRepository.findById(cust.getId()).isPresent())
			return customerRepository.save(cust);
		throw new RuntimeException("Cliente não encontrado");
	}

	public List<Customer> findByNome(String nome) {
		List<Customer> cust = customerRepository.findByNome(nome);
		
		if(cust.isEmpty() == true)
			throw new ResourceNotFoundException("Nenhum cliente com o nome: "+ nome+" foi encontrado");
		return cust;
	}

	public void delete(@Valid Long id) {
		Customer cust = new Customer();
		cust.setId(id);
		customerRepository.delete(cust);
	}

}
