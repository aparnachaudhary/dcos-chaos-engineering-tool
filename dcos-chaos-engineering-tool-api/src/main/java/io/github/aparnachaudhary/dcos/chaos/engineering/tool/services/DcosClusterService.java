package io.github.aparnachaudhary.dcos.chaos.engineering.tool.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.github.aparnachaudhary.dcos.chaos.engineering.tool.entities.MarathonTask;
import io.github.aparnachaudhary.dcos.chaos.engineering.tool.exceptions.DcosChaosException;
import mesosphere.dcos.client.DCOS;
import mesosphere.marathon.client.MarathonException;
import mesosphere.marathon.client.model.v2.App;
import mesosphere.marathon.client.model.v2.GetAppTasksResponse;
import mesosphere.marathon.client.model.v2.GetAppsResponse;

/**
 * Responsible for providing resources available in DCOS.
 *
 * @since 20.04.2018
 */
@Service
public class DcosClusterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DcosClusterService.class);

    private DCOS dcosClient;

    public DcosClusterService(DCOS dcosClient) {
        this.dcosClient = dcosClient;
    }

    public List<String> listMarathonApplications() throws DcosChaosException {
        LOGGER.debug("Listing all the marathon applications.");
        try {
            GetAppsResponse appsResponse = dcosClient.getApps();
            return appsResponse.getApps().stream().map(App::getId).collect(Collectors.toList());
        } catch (MarathonException me) {
            throw new DcosChaosException("Failed to list marathon applications", me);
        }
    }

    public List<MarathonTask> getTasksForAppId(String appId) throws DcosChaosException {
        List<MarathonTask> tasks;
        GetAppTasksResponse tasksResponse = dcosClient.getAppTasks(appId);
        tasks = tasksResponse.getTasks().stream()
                .map(task -> new MarathonTask(task.getId(), task.getAppId(), task.getAgentId(), task.getHost(), task.getState(), task.getStartedAt(),
                        task.getStagedAt())).collect(Collectors.toList());
        return tasks;
    }

    public List<String> listMesosAgents() throws DcosChaosException {
        throw new DcosChaosException("NotYetImplemented");
    }
}
