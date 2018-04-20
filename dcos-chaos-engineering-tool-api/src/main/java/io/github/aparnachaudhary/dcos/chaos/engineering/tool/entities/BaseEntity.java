package io.github.aparnachaudhary.dcos.chaos.engineering.tool.entities;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Base MongoDB Entity
 *
 * @since 20.04.2018
 */
public abstract class BaseEntity {

    private static final String LAST_MODIFIED_ON = "lastModifiedOn";
    private static final String LAST_MODIFIED_BY = "lastModifiedBy";

    @Id
    private String identifier;
    @Version
    private Long version;

    @LastModifiedBy
    @Field(value = LAST_MODIFIED_BY)
    private String lastModifiedBy;

    @LastModifiedDate
    @Field(value = LAST_MODIFIED_ON)
    private Instant lastModifiedOn;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Instant lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }
}
