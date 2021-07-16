package com.markuvinicius.graph.springrestdataneo4j.web;

import com.markuvinicius.graph.springrestdataneo4j.domain.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PersonController {
    public ResponseEntity<List<Person>> getAllPerson();

    public ResponseEntity<Person> postPerson(Person person);

    public ResponseEntity<Person> findById(UUID id);

    public ResponseEntity<Person> update(UUID id, Person person);

}
