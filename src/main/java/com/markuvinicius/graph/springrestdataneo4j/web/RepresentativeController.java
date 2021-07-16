package com.markuvinicius.graph.springrestdataneo4j.web;

import com.markuvinicius.graph.springrestdataneo4j.domain.Person;
import com.markuvinicius.graph.springrestdataneo4j.domain.Representative;
import org.springframework.http.ResponseEntity;

import java.util.Set;
import java.util.UUID;

public interface RepresentativeController {
    public ResponseEntity<Person> postRepresentative(UUID id , Representative representative);

    public ResponseEntity<Set<Representative>> getAllRepresentative(UUID id);
}
