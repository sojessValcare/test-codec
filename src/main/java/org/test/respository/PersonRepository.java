package org.test.respository;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.test.entity.Person;

@ApplicationScoped
public class PersonRepository implements ReactivePanacheMongoRepository<Person> {

    public Uni<Person> findByPersonId(Integer personId) {
        return find("person_id", personId).firstResult();
    }
}
