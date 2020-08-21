package com.yczuoxin.webfluxdemo1.configuration;

import com.yczuoxin.webfluxdemo1.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouteConfiguration {

    @Autowired
    public TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timeRouter() {
        return route(GET("/time"), request -> timeHandler.getTime(request))
                .andRoute(GET("/times"), request -> timeHandler.getTimePerSecond(request))
                .andRoute(GET("/date"), request -> timeHandler.getDate(request));
    }

}
