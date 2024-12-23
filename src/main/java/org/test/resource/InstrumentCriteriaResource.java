package org.test.resource;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.test.dto.InstrumentCriteriaDto;
import org.test.service.InstrumentCriteriaService;

@Produces(MediaType.APPLICATION_JSON)
@Path("/config/instrument-criteria/v1")
public class InstrumentCriteriaResource {

    @Inject
    InstrumentCriteriaService instrumentCriteriaService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> createNewInstrumentCriteria(@Valid InstrumentCriteriaDto instrumentCriteriaDto) {

        Log.info("POST /config/instrument-criteria/v1 --> STARTS");
        return instrumentCriteriaService.addNewInstrumentCriteria(instrumentCriteriaDto)
                .onItem()
                .transform(criteriaResponse -> Response.status(Response.Status.CREATED).entity(criteriaResponse).build())
                .onFailure()
                .recoverWithItem(ex -> {
                    if(ex instanceof ValidationException){

                        return Response.status(Response.Status.BAD_REQUEST).build();
                    }else{
                        Log.error("Unexpected error occured in POST /config/instrument-criteria/v1 e: " + ex.getMessage());
                        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
                    }
                })
                ;

    }

    @GET
    @Path("/{criteriaId}")
    public Uni<Response> getInstrumentCriteriaById(@PathParam("criteriaId") Integer criteriaId){

        Log.info("GET /config/instrument-criteria/v1/" + criteriaId + " --> STARTS");
        return instrumentCriteriaService.getInstrumentCriteriaById(criteriaId)
                .onItem()
                .transform(instrumentCriteriaDto -> Response.ok(instrumentCriteriaDto).build())
                .onFailure().recoverWithItem(ex -> {

                    if(ex instanceof NotFoundException){

                        return Response.status(400).build();
                    }else{

                        Log.error("Error in GET /config/instrument-criteria/v1/" + criteriaId + " e: "+ ex.getMessage());
                        return Response.status(500).build();
                    }
                });
    }

}
