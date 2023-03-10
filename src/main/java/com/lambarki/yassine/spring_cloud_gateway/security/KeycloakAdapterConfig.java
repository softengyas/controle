package com.lambarki.yassine.spring_cloud_gateway.security;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdapterConfig {

    @Bean

    // la configuration se trouve dans application.properties
    KeycloakSpringBootConfigResolver springBootConfigResolver () {
        return new KeycloakSpringBootConfigResolver();
    }
}
