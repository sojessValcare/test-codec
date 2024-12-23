package org.test.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import io.smallrye.mutiny.Uni;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Optional;

@MongoEntity(collection = "persons")
public class Person extends ReactivePanacheMongoEntity {

    @BsonProperty("person_id")
    private Integer personId;

    @BsonProperty("name")
    private String name;

    @BsonProperty("address")
    private Address address;

    public static Uni<Optional<Person>> findByPersonId(Integer personId){

       return find("person_id",personId).firstResultOptional();
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
