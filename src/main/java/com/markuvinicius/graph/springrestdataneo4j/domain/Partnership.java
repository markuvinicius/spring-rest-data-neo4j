package com.markuvinicius.graph.springrestdataneo4j.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RelationshipProperties
public class Partnership {
    @Id @GeneratedValue
    private Long id;

    @TargetNode
    private Person person;

    private long shareHolding;
}
