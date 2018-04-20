package io.github.aparnachaudhary.dcos.chaos.engineering.tool.entities;

import java.time.Duration;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents Mesos Agent configuration for chaos.
 *
 * @since 20.04.2018
 */
@Document(collection = "MarathonApplication")
public class MesosAgentEntity extends BaseEntity {

    private boolean isEnabled;
    private Duration durationBetweenFailure;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Duration getDurationBetweenFailure() {
        return durationBetweenFailure;
    }

    public void setDurationBetweenFailure(Duration durationBetweenFailure) {
        this.durationBetweenFailure = durationBetweenFailure;
    }
}
