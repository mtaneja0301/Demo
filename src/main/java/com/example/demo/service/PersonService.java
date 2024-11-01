package com.example.demo.service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.entity.Person;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        if (person.getId() != null) {
            // If ID is provided, try to update an existing person
            Person existingPerson = personRepository.findById(person.getId()).orElse(null);
            if (existingPerson != null) {
                // Update fields
                existingPerson.setName(person.getName());
                existingPerson.setAddress(person.getAddress());
                existingPerson.setCity(person.getCity());
                existingPerson.setCountry(person.getCountry());
                existingPerson.setDob(person.getDob());
                existingPerson.setAge(person.getAge());
                existingPerson.setGender(person.getGender());
                existingPerson.setRcd_crt_ts(existingPerson.getRcd_upd_ts());
                return personRepository.save(existingPerson);
            } else {
                // Handle case where the entity with the provided ID does not exist
                throw new EntityNotFoundException("Person with ID " + person.getId() + " not found.");
            }
        } else {
            // If no ID is provided, save the new person
            return personRepository.save(person);
        }
    }

    public Optional<Person> findById(Long id){
        Optional<Person> newPerson = personRepository.findById(id);
        return newPerson;
    }

    public Person deletePersonById(Long id) {
        // Fetch the entity before deleting
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            personRepository.deleteById(id); // Delete the entity
        }
        return person; // Return the entity that was deleted, or null if not found
    }

    public List<Person> findAll(){
        List<Person> personList = personRepository.findAll();
        return personList;
    }

    public List<Person> findByCountry(String country){
        List<Person> personList = personRepository.findByCountry(country);
        return personList;
    }
    public List<Person> findByCountryAndCity(String country, String city){
        List<Person> personList = personRepository.findByCountryAndCity(country,city);
        return personList;
    }
    public List<Person> findByGender(String gender){
        List<Person> personList = personRepository.findByGender(gender);
        return personList;

    }
    public List<Person> findByAge(Long age) {
        List<Person> personList = personRepository.findByAge(age);
        return personList;
    }
    public List<Person> findByAgeGreaterThan(Long age) {
        List<Person> personList = personRepository.findByAgeGreaterThan(age);
        return personList;
    }
    public List<String> findNameByAge(Long age) {
        List<String> personList = personRepository.findNameByAge( age);
        return personList;
    }
    public List<String> findNameAndAddressByCountry(String country) {
        List<String> personList = personRepository.findNameAndAddressByCountry(country);
        return personList;
    }


}
