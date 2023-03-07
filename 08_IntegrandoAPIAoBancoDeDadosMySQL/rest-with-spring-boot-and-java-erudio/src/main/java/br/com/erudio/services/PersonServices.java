package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

// Anotaion para encarar essa class como objeto, para que seja injetavel em outra class
@Service
public class PersonServices {

	
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		logger.info("Finding all people!");
		
		
		
		return repository.findAll() ;
	}
	
	public Person findById(Long id) {
		
		logger.info("Finding one person!");
		
		return repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for thid ID!"));
	}
	
	public Person create(Person person) {
		
		logger.info("Creating one person!");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		logger.info("Update one person!");
		
		var entity = repository.findById(person.getId())
			.orElseThrow(()-> new ResourceNotFoundException("No records found for thid ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		entity.setAdress(person.getAdress());
		
		return repository.save(person);
	}
	
	public void delete(long id) {		
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for thid ID!"));
		repository.delete(entity);
	}
}
