package io.github.aparnachaudhary.dcos.chaos.engineering.tool.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.github.aparnachaudhary.dcos.chaos.engineering.tool.exceptions.DcosChaosException;
import io.github.aparnachaudhary.dcos.chaos.engineering.tool.services.MarathonAppChaosService;

/**
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMarathonApps() throws DcosChaosException {
        List<String> appIds = marathonAppChaosService.listMarathonApplications();
        return Response.ok(appIds).build();
    }
}
