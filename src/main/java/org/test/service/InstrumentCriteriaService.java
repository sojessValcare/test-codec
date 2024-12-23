package org.test.service;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.NotFoundException;
import org.test.dto.InstrumentCriteriaDto;
import org.test.entity.InstrumentCriteria;
import org.test.mapper.InstrumentCriteriaMapper;
import org.test.respository.InstrumentCriteriaRepository;

@ApplicationScoped
public class InstrumentCriteriaService {

    @Inject
    InstrumentCriteriaRepository instrumentCriteriaRepository;

    public Uni<InstrumentCriteriaDto> addNewInstrumentCriteria(InstrumentCriteriaDto instrumentCriteriaDto) {

        return instrumentCriteriaRepository.findByCriteriaId(instrumentCriteriaDto.getCriteriaId())
                .onItem().invoke(instrumentCriteriaOpt -> {

                    if(instrumentCriteriaOpt.isPresent()){
                        Log.error("Criteria with criteria id " + instrumentCriteriaDto.getCriteriaId() + " already present");
                        throw new ValidationException("cannot add criteria as it is already present");
                    }
                }).replaceWithVoid()
                .onItem()
                .transform(unused -> InstrumentCriteriaMapper.createCriteriaEntityFromDto(instrumentCriteriaDto))
                .onItem()
                .transformToUni(instrumentCriteria -> instrumentCriteria.<InstrumentCriteria>persist())
                .onItem()
                .transform(InstrumentCriteriaMapper::convertCriteriaEntityToResponse);
    }

    public Uni<InstrumentCriteriaDto> getInstrumentCriteriaById(Integer criteriaId) {

        return  instrumentCriteriaRepository.findByCriteriaId(criteriaId).onItem()
                .transform(criteriaOpt -> {

                    if(criteriaOpt.isPresent()){
                        return  criteriaOpt.get();
                    }else{
                        Log.error("Instrument criteria with id: " + criteriaId + " not found");
                        throw new NotFoundException("Invalid criteria id provided");
                    }
                })
                .onItem()
                .transform(InstrumentCriteriaMapper::convertCriteriaEntityToResponse);
    }

}
