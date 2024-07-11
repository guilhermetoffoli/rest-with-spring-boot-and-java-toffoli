package br.com.toffoli.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.toffoli.exceptions.ResourceNotFoundException;
import br.com.toffoli.model.Person;
import br.com.toffoli.repositories.PersonRepository;


@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll(){
		
		
		logger.info("Finding all people!");
		
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		logger.info("Finding one person!");
		 		
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {
		
		logger.info("Creating one person!");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getId()).orElseThrow(
				() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		entity.setAddress(person.getAddress());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("No records found for this ID!"));
		logger.info("Deleting one person!");
		repository.delete(entity);
	}
	
}
