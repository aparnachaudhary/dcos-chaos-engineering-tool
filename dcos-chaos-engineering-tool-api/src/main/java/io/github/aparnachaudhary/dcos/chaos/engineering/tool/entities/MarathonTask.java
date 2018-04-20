package io.github.aparnachaudhary.dcos.chaos.engineering.tool.entities;

/**
 * Represents Marathon task.
 *
 * @since 20.04.2018
 */
public class MarathonTask {

    private String taskId;
    private String appId;
    private String agentId;
    private String host;
    private String state;
    private String startedAt;
    private String stagedAt;


    public MarathonTask(String taskId, String appId, String agentId, String host, String state, String startedAt, String stagedAt) {
        this.taskId = taskId;
        this.appId = appId;
        this.agentId = agentId;
        this.host = host;
        this.state = state;
        this.startedAt = startedAt;
        this.stagedAt = stagedAt;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getStagedAt() {
        return stagedAt;
    }

    public void setStagedAt(String stagedAt) {
        this.stagedAt = stagedAt;
    }
}
