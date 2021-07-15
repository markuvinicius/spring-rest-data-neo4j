package com.markuvinicius.graph.springrestdataneo4j.service;

import com.markuvinicius.graph.springrestdataneo4j.domain.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {

    public List<Person> findAll();

    public Person save(Person person);

    public Person findById(UUID id);
}