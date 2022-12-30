package com.lambarki.yassine.gatewayservice.config;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

        //@Bean
        RouteLocator routeLocator(RouteLocatorBuilder builder) {
            return builder.routes()
                    .route("r1", r -> r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
                    .route("r2", r -> r.path("/products/**").uri("lb://PRODUCT-SERVICE"))
                    .build();
        }

    @Bean
    DiscoveryClientRouteDefinitionLocator discoveryRoutes(ReactiveDiscoveryClient rdc,
                                                          DiscoveryLocatorProperties dlp) {
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }

    }

