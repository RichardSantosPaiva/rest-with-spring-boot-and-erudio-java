package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class);

    public List<Person> findAll(){
        
    	logger.info("Finding all people!");
        
    	List<Person> persons = new ArrayList<>();
    	for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons ;
    }
    
    public Person create(Person person) {
        logger.info("Creating one person!");
    	return person;
    }
    
    public Person update(Person person) {
        logger.info("Updating one person!");
    	return person;
    }

    public void delete(String id) {
    	logger.info("Deleting one person!");
    }
    
	public Person findById(String id) {
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("Uberlândia - MG - Brasil");
        person.setGender("Male");

        return person;
    }
	
	   private Person mockPerson(int i) {
		   logger.info("Finding one person!");
	        Person person = new Person();
	        person.setId(counter.incrementAndGet());
	        person.setFirstName("Person Name" + i);
	        person.setLastName("Last Name"+ i);
	        person.setAddress("Some addres in Brasil "+ i);
	        person.setGender("Male");
	        return person;
		}
}
