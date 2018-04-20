package io.github.aparnachaudhary.dcos.chaos.engineering.tool.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.aparnachaudhary.dcos.chaos.engineering.tool.entities.MarathonApplicationEntity;

/**
 * Repository for CRUD operations on {@link MarathonApplicationEntity}
 *
 * @since 20.04.2018
 */
@Repository
public interface MarathonApplicationRepository extends MongoRepository< MarathonApplicationEntity, String> {
}
