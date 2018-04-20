package io.github.aparnachaudhary.dcos.chaos.engineering.tool.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.github.aparnachaudhary.dcos.chaos.engineering.tool.entities.MarathonApplicationEntity;
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

}
