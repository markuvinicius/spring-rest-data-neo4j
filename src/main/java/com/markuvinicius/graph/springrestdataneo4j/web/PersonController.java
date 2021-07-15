package com.markuvinicius.graph.springrestdataneo4j.web;

import com.markuvinicius.graph.springrestdataneo4j.domain.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface PersonController {

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPerson();

    @PostMapping("/person")
    public ResponseEntity<Person> postPerson(Person person);

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> findById(UUID id);
}
