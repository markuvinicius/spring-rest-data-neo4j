package com.markuvinicius.graph.springrestdataneo4j.web.impl;

import com.markuvinicius.graph.springrestdataneo4j.domain.Person;
import com.markuvinicius.graph.springrestdataneo4j.exception.ResourceNotFoundException;
import com.markuvinicius.graph.springrestdataneo4j.service.PersonService;
import com.markuvinicius.graph.springrestdataneo4j.web.PersonController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonControllerImpl implements PersonController{

    private PersonService personService;

    @Autowired
    public PersonControllerImpl(PersonService personService){
        this.personService = personService;
    }

    @Override
    @GetMapping
    @ApiOperation(value="Returns all Person vertix, with their connections")
    public ResponseEntity<List<Person>> getAllPerson(){
            return new ResponseEntity( personService.findAll() , HttpStatus.OK);
    }

    @Override
    @PostMapping
    @ApiOperation(value="Add a new Person vertix to the Graph")
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {
        return new ResponseEntity( personService.save(person) , HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    @ApiOperation(value="Returns a specific Person vertix by its unique ID")
    public ResponseEntity<Person> findById(@PathVariable UUID id) {
        return new ResponseEntity( personService.findById(id) , HttpStatus.OK );
    }

    @Override
    @PutMapping("/{id}")
    @ApiOperation(value="Update a specific Person vertix attributtes by its unique ID")
    public ResponseEntity<Person> update(@PathVariable UUID id, @RequestBody Person person) throws ResourceNotFoundException {
        Person statedPerson = personService.findById(id);
        statedPerson.setId(statedPerson.getId());
        statedPerson.setFirstName(person.getFirstName());
        statedPerson.setLastName(person.getLastName());
        statedPerson.setCnpj(person.getCnpj());

        return new ResponseEntity( personService.save(statedPerson) , HttpStatus.OK );
    }


}
