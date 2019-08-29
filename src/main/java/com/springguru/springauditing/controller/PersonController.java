package com.springguru.springauditing.controller;

import com.springguru.springauditing.model.Person;
import com.springguru.springauditing.payload.PersonPayload;
import com.springguru.springauditing.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping(value = {"person", "person/"})
    public ResponseEntity<?> createPerson(@Valid @RequestBody PersonPayload personPayload,
                                          BindingResult result) {
        System.err.println(personPayload);
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors().get(0), HttpStatus.BAD_REQUEST);
        }

        Person person = new Person();
        person.setName(personPayload.getName());
        person.setGender(personPayload.getGender());
        person.setAge(personPayload.getAge());


        return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
    }

    @GetMapping(value = {"all", "all/"})
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }



}
