package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.CarBusiness;
import com.example.demo.model.Car;

@Service
public class CarService{

	@Autowired
	private CarBusiness carBusiness;
	
	public void delete(long id) {
		carBusiness.delete(id);		
	}

	public Car update(Car car) {
		return carBusiness.update(car);
	}

	public List<Car> findAll() {
		return carBusiness.findAll();
	}

	public Car save(Car car) {
		return carBusiness.save(car);
		
	}
//	@Transactional
//	public Car teste(Car car) {
//		carBusiness.save(car);
//		car.setModelo("vectra");
//		carBusiness.update(car);
//		return car;
//	}
//	
	public Car findById(long id) {
		return carBusiness.findById(id);
	}

	public List<Car> findByModelo(String modelo) {
		return carBusiness.findByModelo(modelo);
	}

	public List<Car> saveAll(@Valid List<Car> car) {
		return carBusiness.saveAll(car);		
	}
}