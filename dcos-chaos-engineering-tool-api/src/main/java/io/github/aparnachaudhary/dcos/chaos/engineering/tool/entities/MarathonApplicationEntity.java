package io.github.aparnachaudhary.dcos.chaos.engineering.tool.entities;

import java.time.Duration;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents Marathon application configuration for chaos.
 *
 * @since 20.04.2018
 */
@Document(collection = "MarathonApplication")
public class MarathonApplicationEntity extends BaseEntity {

    private boolean isEnabled;
    private Duration durationBetweenFailure;
    private ReaperPolicy reaperPolicy;
    private String reaperValue;


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

    public ReaperPolicy getReaperPolicy() {
        return reaperPolicy;
    }

    public void setReaperPolicy(ReaperPolicy reaperPolicy) {
        this.reaperPolicy = reaperPolicy;
    }

    public String getReaperValue() {
        return reaperValue;
    }

    public void setReaperValue(String reaperValue) {
        this.reaperValue = reaperValue;
    }
}
