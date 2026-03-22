package com.yczuoxin.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Slf4j
@Configuration
public class WebConfiguration {

    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return route(GET("hello-world"), request -> ok().body(Mono.just("Hello, World!"), String.class));
    }

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        log.info("WebConfiguration: 当前 WebServer 实现类为 {}", event.getWebServer().getClass().getName());
    }

    @Bean
    public ApplicationRunner runner(WebServerApplicationContext context) {
        return args -> {
            log.info("当前 HelloWorld Bean 实现类为 {}", context.getBean("helloWorld").getClass().getName());
            log.info("当前 WebConfiguration Bean 实现类为 {}", context.getBean(WebConfiguration.class).getClass().getName());
        };
    }

}
