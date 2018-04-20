package io.github.aparnachaudhary.dcos.chaos.engineering.tool.resources;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Bootstrap for Jersey.
 *
 * @since 20.04.2018
 */
@Component
public class JerseyConfig extends ResourceConfig {

    @Value("${spring.jersey.applicationPath}")
    private String apiPath;

    public JerseyConfig() {
        // resources
        this.register(ClusterResource.class);
        this.register(MarathonAppsResource.class);
        // exceptions mappers
    }

}
