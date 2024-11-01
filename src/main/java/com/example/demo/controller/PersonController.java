package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    @PostMapping("/save")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.save(person));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personService.findAll());

    }

    @GetMapping("/findById")
    public ResponseEntity<Person> findById(@RequestParam Long id) {
        return ResponseEntity.ok(personService.findById(id)
                .orElse(null));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<Person> deleteById(@RequestParam Long id) {
        return ResponseEntity.ok(personService.deletePersonById(id));
    }

    @GetMapping("/findByCountry")
    public ResponseEntity<List<Person>> findByCountry(@RequestParam String country) {
        return ResponseEntity.ok(personService.findByCountry(country));
    }

    @GetMapping("/findByCountryAndCity")
    public ResponseEntity<List<Person>> findByCountryAndCity(@RequestParam String country, @RequestParam String city) {
        return ResponseEntity.ok(personService.findByCountryAndCity(country, city));
    }

    @GetMapping("/findByGender")
    public ResponseEntity<List<Person>> findByGender(@RequestParam String gender) {
        return ResponseEntity.ok(personService.findByGender(gender));
    }

    @GetMapping("/findByAge")
    public ResponseEntity<List<Person>> findByAge(@RequestParam Long age) {
        return ResponseEntity.ok(personService.findByAge(age));
    }

    @GetMapping("/findByAgeGreaterThan")
    public ResponseEntity<List<Person>> findByAgeGreaterThan(@RequestParam Long age) {
        return ResponseEntity.ok(personService.findByAgeGreaterThan(age));
    }

    @GetMapping("/findNameByAge")
    public ResponseEntity<List<String>> findNameByAge(@RequestParam Long age) {
        return ResponseEntity.ok(personService.findNameByAge(age));
    }

    @GetMapping("/findNameAndAddressByCountry")
    public ResponseEntity<List<String>> findNameAndAddressByCountry(@RequestParam String country) {
        return ResponseEntity.ok(personService.findNameAndAddressByCountry(country));
    }
}


