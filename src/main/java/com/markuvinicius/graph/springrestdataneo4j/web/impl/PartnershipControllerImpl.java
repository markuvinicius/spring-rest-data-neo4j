package com.markuvinicius.graph.springrestdataneo4j.web.impl;

import com.markuvinicius.graph.springrestdataneo4j.domain.Partner;
import com.markuvinicius.graph.springrestdataneo4j.domain.Person;
import com.markuvinicius.graph.springrestdataneo4j.exception.ResourceNotFoundException;
import com.markuvinicius.graph.springrestdataneo4j.repository.PersonRepository;
import com.markuvinicius.graph.springrestdataneo4j.service.PersonService;
import com.markuvinicius.graph.springrestdataneo4j.web.PartnershipController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/person/{id}/partnership")
public class PartnershipControllerImpl implements PartnershipController {

    private PersonService personService;

    @Autowired
    public PartnershipControllerImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    @PostMapping
    @ApiOperation(value="Add a new Partnership relation between two people")
    public ResponseEntity<Person> postPartnership(@PathVariable UUID id, @RequestBody Partner partner) throws ResourceNotFoundException{
        Person statedPerson = personService.findById(id);
        statedPerson.setPartner(partner);
        personService.save(statedPerson);
        return new ResponseEntity( statedPerson , HttpStatus.CREATED );
    }

    @Override
    @GetMapping
    @ApiOperation(value="Returns all parnership relations of a specific person vertix")
    public ResponseEntity<Set<Partner>> getAllPartners(@PathVariable UUID id) throws ResourceNotFoundException{
        Person statedPerson = personService.findById(id);
        return new ResponseEntity( statedPerson.getPartnership() , HttpStatus.OK );
    }
}
