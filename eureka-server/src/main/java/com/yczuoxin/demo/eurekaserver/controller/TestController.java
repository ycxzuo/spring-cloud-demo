package com.yczuoxin.demo.eurekaserver.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;


@RestController
public class TestController {

    @GetMapping("/close")
    public void close(){
        System.out.println("closing");
        // 测试
        System.exit(-1);
    }

    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return RouterFunctions.route(RequestPredicates.GET("/hello-world"), request -> ServerResponse.ok().body(Mono.just("hello")));
    }

}

