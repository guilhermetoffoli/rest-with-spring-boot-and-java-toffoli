package br.com.toffoli.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;
import br.com.toffoli.model.Person;
import br.com.toffoli.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;

	@GetMapping
	public List<Person> findAll(){
		
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable(value = "id") Long id){
		
		return service.findById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public Person create(@RequestBody Person person){
		
		return service.create(person);
	}
	
	@PutMapping
	public Person update(@RequestBody Person person){
		
		return service.update(person);
	}
}
