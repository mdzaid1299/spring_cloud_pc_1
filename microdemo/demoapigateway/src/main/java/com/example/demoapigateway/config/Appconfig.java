package com.example.demoapigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig
{

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes().
                route(p->p
                        .path("/userservice/**")
                        .uri("lb://authentication-service:64200/")
                )
                .route(p->p
                        .path("/usermovieapp/user/**")
                        .uri("lb://movie-service:64100/"))
                .build();


    }
}
