package io.github.aparnachaudhary.dcos.chaos.engineering.tool.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.github.aparnachaudhary.dcos.chaos.engineering.tool.exceptions.DcosChaosException;
import mesosphere.dcos.client.DCOS;
import mesosphere.marathon.client.MarathonException;
import mesosphere.marathon.client.model.v2.App;
import mesosphere.marathon.client.model.v2.GetAppsResponse;

/**
 * Responsible for configuring chaos entity.
 *
 * @since 20.04.2018
 */
@Service
public class MarathonAppChaosService {

    private final Logger LOGGER = LoggerFactory.getLogger(MarathonAppChaosService.class);

    private DCOS dcosClient;

    public MarathonAppChaosService(DCOS dcosClient) {
        this.dcosClient = dcosClient;
    }

    public List<String> listMarathonApplications() throws DcosChaosException {
        try {
            GetAppsResponse appsResponse = dcosClient.getApps();
            return appsResponse.getApps().stream().map(App::getId).collect(Collectors.toList());
        } catch (MarathonException me) {
            throw new DcosChaosException("Failed to list applications", me);
        }

    }


}
