package org.test.respository;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.test.entity.InstrumentCriteria;

import java.util.Optional;

@ApplicationScoped
public class InstrumentCriteriaRepository implements ReactivePanacheMongoRepository<InstrumentCriteria> {

    public Uni<Optional<InstrumentCriteria>> findByCriteriaId(Integer criteriaId){

        return find("criteria",criteriaId).firstResultOptional();
    }
}
