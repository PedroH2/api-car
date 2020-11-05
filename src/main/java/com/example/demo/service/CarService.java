package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Car;


public interface CarService{
	List<Car> findAll();
	Car findById(Long id);
	Car save(Car car);
	Car findByModel(String modelo);
}
