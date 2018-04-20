package io.github.aparnachaudhary.dcos.chaos.engineering.tool.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import io.github.aparnachaudhary.dcos.chaos.engineering.tool.exceptions.DcosChaosException;
import io.github.aparnachaudhary.dcos.chaos.engineering.tool.services.DcosClusterService;

/**
 * Provides API to list resources available in DCOS cluster.
 *
 * @since 20.04.2018
 */
@Path("cluster")
@Component
public class ClusterResource {

    private DcosClusterService dcosClusterService;

    public ClusterResource(DcosClusterService dcosClusterService) {
        this.dcosClusterService = dcosClusterService;
    }

    @Path("apps")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMarathonApps() throws DcosChaosException {
        List<String> appIds = dcosClusterService.listMarathonApplications();
        return Response.ok(appIds).build();
    }

    @Path("agents")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMesosAgents() throws DcosChaosException {
        List<String> agentIds = dcosClusterService.listMesosAgents();
        return Response.ok(agentIds).build();
    }
}
