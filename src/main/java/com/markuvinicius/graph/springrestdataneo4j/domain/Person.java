package com.markuvinicius.graph.springrestdataneo4j.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Set;
import java.util.UUID;

@Node(labels = {"Person"})
@AllArgsConstructor
public class Person {

    @Id
    @Getter @Setter
    private UUID id;

    @Getter @Setter
    @Property("firstName")
    private String firstName;

    @Getter @Setter
    @Property("lastName")
    private String lastName;

    @Getter @Setter
    @Property("cnpj")
    private String cnpj;

    @Getter
    @Relationship(type="PARTNER")
    private Set<Partner> partnership;

    @Getter
    @Relationship(type="REPRESENTATIVE")
    private Set<Representative> representatives;

    public void setPartner(Partner partner){
        this.partnership.add(partner);
    }

    public void setRepresentative(Representative representative){
        this.representatives.add(representative);
    }
}
