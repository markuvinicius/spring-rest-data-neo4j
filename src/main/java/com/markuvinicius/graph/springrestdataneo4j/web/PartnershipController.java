package com.markuvinicius.graph.springrestdataneo4j.web;

import com.markuvinicius.graph.springrestdataneo4j.domain.Partner;
import com.markuvinicius.graph.springrestdataneo4j.domain.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PartnershipController {
    public ResponseEntity<Person> postPartnership(UUID id , Partner partner);

    public ResponseEntity<Set<Partner>> getAllPartners(UUID id);
}
