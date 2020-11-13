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

import com.example.demo.dto.CarDTO;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;

@RestController
@RequestMapping(value="/api")
public class CarController {
	
	@Autowired
	private CarService carService;
		
	@GetMapping("/listAll")
	public List<Car> listaCarros(){
		return carService.findAll();
	}
	@PostMapping("/car")
	public String  salvaCarro(@Valid @RequestBody CarDTO car) {
		 carService.save(car.carro());
		 
		 return "carro salvo";
	
	}
	@DeleteMapping("/{id}")
	public void deletaCarro(@PathVariable long id) {
		carService.delete(id);
	}
	@PutMapping("/car")
	public Car atualizaCarro(@Valid @RequestBody CarDTO car) {
		return carService.update(car.carro());
	}
	@GetMapping("/{id}")
	public Car getCarroById(@PathVariable long id){
		return carService.findById(id);
	}
	@GetMapping("/car/{modelo}")
	public List<Car> getCarroByModelo(@PathVariable String modelo) {
		return carService.findByModelo(modelo);
	}
	@PostMapping("/car/salvarCarros")
	public String salvaMultiplosCarros(@Valid @RequestBody List<Car> car) {
		carService.saveAll(car);
		return "Carros salvos";
	}
}