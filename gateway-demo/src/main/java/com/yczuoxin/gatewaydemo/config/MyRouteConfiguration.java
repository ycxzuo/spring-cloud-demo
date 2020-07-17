package com.yczuoxin.gatewaydemo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRouteConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", p -> p.path("/csdn")
                .filters(f -> f.addRequestHeader("Hello", "World"))
                .uri("https://blog.csdn.net")
                ).build();
    }


}
