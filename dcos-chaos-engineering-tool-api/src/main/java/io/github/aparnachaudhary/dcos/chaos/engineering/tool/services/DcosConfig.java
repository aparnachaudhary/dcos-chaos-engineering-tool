package io.github.aparnachaudhary.dcos.chaos.engineering.tool.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mesosphere.dcos.client.DCOS;
import mesosphere.dcos.client.DCOSClient;
import mesosphere.dcos.client.model.DCOSAuthCredentials;

/**
 * Provides configuration for communication with DCOS.
 *
 * @since 20.04.2018
 */
@Configuration
public class DcosConfig {

    @Value("${dcos.marathon.service.baseUrl}")
    private String marathonBaseUrl;
    @Value("${dcos.marathon.service.connectionTimeout}")
    private int marathonConnectionTimeout;
    @Value("${dcos.marathon.service.readTimeout}")
    private int marathonReadTimeout;
    @Value("${dcos.marathon.service.auth.enabled}")
    private boolean marathonAuthEnabled;
    @Value("${dcos.marathon.service.auth.username}")
    private String marathonUsername;
    @Value("${dcos.marathon.service.auth.password}")
    private String marathonPassword;


    /**
     * Constructs DCOS client with/without basic authentication.
     *
     * @return DCOS client for application management
     */
    @Bean
    public DCOS getDCOSClient() {
        final DCOS dcos;
        if (marathonAuthEnabled) {
            dcos = DCOSClient.getInstance(marathonBaseUrl, DCOSAuthCredentials.forUserAccount(marathonUsername, marathonPassword));
        } else {
            dcos = DCOSClient.getInstance(marathonBaseUrl);
        }
        return dcos;
    }
}
