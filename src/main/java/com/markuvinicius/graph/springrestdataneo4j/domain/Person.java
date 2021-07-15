package com.markuvinicius.graph.springrestdataneo4j.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Set;
import java.util.UUID;

@Node("Person")
@Data
@AllArgsConstructor
public class Person {

    @Id
    private UUID id;

    @Property("firstName")
    private String firstName;

    @Property("lastName")
    private String lastName;

    @Property("cnpj")
    private String cnpj;

    //@Relationship(type="PARTNERSHIP", direction = Relationship.Direction.INCOMING)
    //private Set<Person> partners;

    @Relationship(type="PARTNERSHIP")
    private Set<Partnership> partnership;
}
