package io.github.aparnachaudhary.dcos.chaos.engineering.tool.services;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.github.aparnachaudhary.dcos.chaos.engineering.tool.entities.MarathonApplicationEntity;
import io.github.aparnachaudhary.dcos.chaos.engineering.tool.exceptions.DcosChaosException;
import io.github.aparnachaudhary.dcos.chaos.engineering.tool.repositories.MarathonApplicationRepository;

/**
 * Responsible for configuring chaos entity.
 *
 * @since 20.04.2018
 */
@Service
public class MarathonAppChaosService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarathonAppChaosService.class);

    private MarathonApplicationRepository applicationRepository;


    public MarathonAppChaosService(MarathonApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public MarathonApplicationEntity createOptInApplication(MarathonApplicationEntity entity) {

        Objects.requireNonNull(entity, "MarathonApplication must not be null");
        LOGGER.debug("Creating opt-in for marathon application={}", entity);
        if (entity.getLastModifiedOn() == null) {
            entity.setLastModifiedOn(Instant.now());
        }
        return applicationRepository.save(entity);
    }

    public MarathonApplicationEntity getById(String identifier) throws DcosChaosException {
        final Optional<MarathonApplicationEntity> entity = applicationRepository.findById(identifier);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new DcosChaosException("Failed to retrieve the entity with identifier=" + identifier);
        }
    }
}
