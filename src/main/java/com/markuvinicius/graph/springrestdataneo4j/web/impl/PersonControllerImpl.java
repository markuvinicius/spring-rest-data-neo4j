package com.markuvinicius.graph.springrestdataneo4j.web.impl;

import com.markuvinicius.graph.springrestdataneo4j.domain.Person;
import com.markuvinicius.graph.springrestdataneo4j.service.PersonService;
import com.markuvinicius.graph.springrestdataneo4j.web.PersonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class PersonControllerImpl implements PersonController{

    private PersonService personService;

    @Autowired
    public PersonControllerImpl(PersonService personService){
        this.personService = personService;
    }

    @Override
    public ResponseEntity<List<Person>> getAllPerson(){
            return new ResponseEntity( personService.findAll() , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {
        return new ResponseEntity( personService.save(person) , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Person> findById(@RequestParam UUID id) {
        return new ResponseEntity( personService.findById(id) , HttpStatus.OK );
    }


}
