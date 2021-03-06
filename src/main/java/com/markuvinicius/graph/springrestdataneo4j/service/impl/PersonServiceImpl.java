package com.markuvinicius.graph.springrestdataneo4j.service.impl;

import com.markuvinicius.graph.springrestdataneo4j.domain.Person;
import com.markuvinicius.graph.springrestdataneo4j.exception.ResourceNotFoundException;
import com.markuvinicius.graph.springrestdataneo4j.repository.PersonRepository;
import com.markuvinicius.graph.springrestdataneo4j.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findById(UUID id)  throws ResourceNotFoundException {
        return personRepository
                .findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Person Not Found"));
    }

    @Override
    public Set<Person> findPartnership(UUID id, Optional<String> direction){
        return direction.map( d -> this.findDirectedPartnership(id,d) ).orElseThrow( () -> new RuntimeException("Deu Ruim"));
    }

    private Set<Person> findDirectedPartnership(UUID id, String direction){
        switch (direction){
            case "inbound": return personRepository.findPartnership(id);
            case "outbound": return personRepository.findPartners(id);
            default: return null;
        }
    }
}
