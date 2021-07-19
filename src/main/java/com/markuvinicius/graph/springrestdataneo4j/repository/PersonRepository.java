package com.markuvinicius.graph.springrestdataneo4j.repository;

import com.markuvinicius.graph.springrestdataneo4j.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, UUID> {
    List<Person> findAll();

    Person save(Person person);

    @Query("MATCH (a:Person{id:$id})-[:PARTNER]->(b:Person) RETURN b")
    Set<Person> findPartners(@Param("id") UUID id);

    @Query("MATCH (a:Person)-[:PARTNER]->(b:Person{id:$id}) RETURN a")
    Set<Person> findPartnership(@Param("id") UUID id);
}
