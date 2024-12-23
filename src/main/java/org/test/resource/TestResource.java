package org.test.resource;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.test.dto.PersonDto;
import org.test.service.TestService;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    @Inject
    TestService testService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> createPersonObject(PersonDto personDto) {

        return testService.createPerson(personDto)
                .onItem()
                .transform(personDto1 -> Response.ok(personDto1).build());
    }

    @GET
    @Path("/{personId}")
    public Uni<Response> getPersonObject(@PathParam("personId") Integer personId) {

        return testService.getPersonObject(personId)
                .onItem()
                .transform(personDto -> Response.ok(personDto).build());
    }
}
