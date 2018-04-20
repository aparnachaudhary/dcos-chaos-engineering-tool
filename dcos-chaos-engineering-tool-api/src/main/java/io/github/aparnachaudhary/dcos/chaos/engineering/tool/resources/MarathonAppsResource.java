package io.github.aparnachaudhary.dcos.chaos.engineering.tool.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.github.aparnachaudhary.dcos.chaos.engineering.tool.entities.MarathonApplicationEntity;
import io.github.aparnachaudhary.dcos.chaos.engineering.tool.exceptions.DcosChaosException;
import io.github.aparnachaudhary.dcos.chaos.engineering.tool.services.MarathonAppChaosService;

/**
 * API for configuration of marathon applications for Chaos.
 *
 * @since 20.04.2018
 */
@Path("/apps")
@Component
public class MarathonAppsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarathonAppsResource.class);

    private MarathonAppChaosService marathonAppChaosService;

    public MarathonAppsResource(MarathonAppChaosService marathonAppChaosService) {
        this.marathonAppChaosService = marathonAppChaosService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOptInApplication(MarathonApplicationEntity marathonApplication, @Context final UriInfo uriInfo) {

        LOGGER.debug("Creating entity={}", marathonApplication);
        MarathonApplicationEntity saved = marathonAppChaosService.createOptInApplication(marathonApplication);
        final URI location = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", saved.getIdentifier())
                .build();
        return Response.created(location).build();
    }


    @Path("{identifier}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOptInApplication(@PathParam("identifier") final String identifier, MarathonApplicationEntity marathonApplication,
                                           @Context final UriInfo uriInfo) throws DcosChaosException {
        throw new DcosChaosException("NotYetImplemented");
    }

    @Path("{identifier}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApplication(@PathParam("identifier") final String identifier) {
        try {
            MarathonApplicationEntity applicationEntity = marathonAppChaosService.getById(identifier);
            return Response.ok(applicationEntity).build();
        } catch (DcosChaosException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
