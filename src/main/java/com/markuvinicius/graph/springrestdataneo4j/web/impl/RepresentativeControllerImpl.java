package com.markuvinicius.graph.springrestdataneo4j.web.impl;

import com.markuvinicius.graph.springrestdataneo4j.domain.Person;
import com.markuvinicius.graph.springrestdataneo4j.domain.Representative;
import com.markuvinicius.graph.springrestdataneo4j.exception.ResourceNotFoundException;
import com.markuvinicius.graph.springrestdataneo4j.service.PersonService;
import com.markuvinicius.graph.springrestdataneo4j.web.RepresentativeController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/person/{id}/representation")
public class RepresentativeControllerImpl implements RepresentativeController {

    private PersonService personService;

    @Autowired
    public RepresentativeControllerImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    @PostMapping
    @ApiOperation(value="Add a new Representantive relation between two people")
    public ResponseEntity<Person> postRepresentative(@PathVariable UUID id, @RequestBody Representative representative) throws ResourceNotFoundException {
        Person statedPerson = personService.findById(id);
        statedPerson.setRepresentative(representative);
        personService.save(statedPerson);
        return new ResponseEntity( statedPerson , HttpStatus.CREATED );
    }

    @Override
    @GetMapping
    @ApiOperation(value="Returns all representative relations of a specific person vertix")
    public ResponseEntity<Set<Representative>> getAllRepresentative(@PathVariable UUID id)  throws ResourceNotFoundException{
        Person statedPerson = personService.findById(id);
        return new ResponseEntity( statedPerson.getRepresentatives() , HttpStatus.OK );
    }
}
