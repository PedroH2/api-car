package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Service;

import com.example.demo.business.CustomerBusiness;
import com.example.demo.model.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerBusiness customerBusiness;

	@Autowired
	CarService carService;

	@Autowired
	CustomerService customerService;
	
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

	public String Compra(Car car, Customer cust) {
		double saldoPosCompra;

		if (validaCompra(cust.getSaldoemconta(), car.getValor())) {
			saldoPosCompra = cust.getSaldoemconta() - car.getValor();
			cust.setSaldoemconta(saldoPosCompra);
			customerService.update(cust);
			if (car.getQtdEstoque() == 1) {
				carService.delete(car.getId());
			} else {
				car.setQtdEstoque(car.getQtdEstoque() - 1);
				carService.update(car);
			}
		} else {
			return "Compra não efetuada";
		}
		return "Compra efetuada com sucesso!";
	}

	public boolean validaCompra(double saldo, double valorAdebitar) {
		if (saldo < valorAdebitar)
			return false;
		else
			return true;
	}
}
