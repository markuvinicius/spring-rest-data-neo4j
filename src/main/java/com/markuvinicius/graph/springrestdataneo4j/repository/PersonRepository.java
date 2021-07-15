package com.markuvinicius.graph.springrestdataneo4j.repository;

import com.markuvinicius.graph.springrestdataneo4j.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;
import java.util.UUID;


public interface PersonRepository extends Neo4jRepository<Person, UUID> {
    List<Person> findAll();

    Person save(Person person);
}
