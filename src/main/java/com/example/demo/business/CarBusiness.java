package com.example.demo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.model.Car;
import com.example.demo.model.Customer;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import com.example.demo.service.CustomerService;

@Component
public class CarBusiness {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarService carService;

	public void delete(long id) {
		Car car = new Car();
		car.setId(id);
		carRepository.delete(car);

	}

	public Car update(Car car) {
		if (carRepository.findById(car.getId()).isPresent()) {
			return carRepository.save(car);
		}
		throw new ResourceNotFoundException("Carro não encontrado para id: " + car.getId());
	}

	public List<Car> findAll() {
		return carRepository.findAll();
	}

	public Car save(Car car) {
		if (car == null)
			throw new RuntimeException("Carro não pode ser nulo");
		return carRepository.save(car);
	}

	public Car findById(long id) {
		if (carRepository.findById(id) == null)
			throw new ResourceNotFoundException("Carro com id: " + id + " não encontrado.");

		return carRepository.findById(id);
	}

	public List<Car> findByModelo(String modelo) {
		List<Car> carros = carRepository.findByModelo(modelo);
		if (carros.isEmpty())
			throw new ResourceNotFoundException("Nenhum carro do modelo: " + modelo + " foi encontrado.");

		return carros;
	}

	public List<Car> saveAll(List<Car> car) {
		return carRepository.saveAll(car);
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