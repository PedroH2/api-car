package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.CarBusiness;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Car;
import com.example.demo.model.Customer;
import com.example.demo.service.CarService;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CarService carService;
	
	@GetMapping("findAll")
	public List<Customer> listCust(){
		return customerService.findAll();
	}

	@PostMapping("saveCustomer")
	public String save (@Valid @RequestBody CustomerDTO cust) {
		customerService.save(cust.cliente());
		return "Salvo";
	}

	@GetMapping("getCustomerById/{id}")
	public Customer findById(@PathVariable Long id) {
		return customerService.findById(id);
	}

	@PutMapping("updateCustomer")
	public Customer update(@Valid @RequestBody CustomerDTO cust) {
		return customerService.update(cust.cliente());
	}

	@DeleteMapping("deleteCustomerById/{id}")
	public String delete(@Valid @PathVariable Long id) {
		customerService.delete(id);		
		return "Deletado";
	}

	@GetMapping("getCustomerByName/{nome}")
	public List<Customer> findByNome(@PathVariable String nome){
		return customerService.findByNome(nome);
	}

	@PutMapping("buyCar/{id}/{idCli}")
	public String Compra(@Valid @PathVariable Long id, @PathVariable Long idCli) {
		Car car = carService.findById(id);
		Customer cust = customerService.findById(idCli);
		return customerService.Compra(car, cust);
	}
}
