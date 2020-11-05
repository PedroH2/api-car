package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;

@RestController
public class CarController {
	
	List<Car> listCar = new ArrayList<>();

	@Autowired
	CarRepository carRepository;

	
	@GetMapping("/cars")
	public List<Car> listaCarros(){
		return carRepository.findAll();
	}
	@PostMapping("/car")
	public String  salvaCarro(@RequestBody Car car) {
		 carRepository.save(car);
		 
		 return "carro salvo";
	
	}
	@DeleteMapping("/car")
	public void deletaCarro(@RequestBody Car car) {
		carRepository.delete(car);
	}
	@PutMapping("/car")
	public Car atualizaCarro(@RequestBody Car car) {
		return carRepository.save(car);
	}
	@GetMapping("/car/{id}")
	public Car getCarroById(@PathVariable long id){
		return carRepository.findById(id);
	}
}
