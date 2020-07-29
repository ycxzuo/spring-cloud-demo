package com.yczuoxin.demo.eurekaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value = "/services", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getServices() {
        return discoveryClient.getServices();
    }

    @GetMapping(value = "/services/{serviceName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServiceInstance> getServiceByName(@PathVariable String serviceName) {
        return discoveryClient.getInstances(serviceName);
    }

    @GetMapping(value = "/services/{serviceName}/{instanceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceInstance getInstanceById(@PathVariable String serviceName, @PathVariable String instanceId) {
        return discoveryClient.getInstances(serviceName).stream()
                .filter(p -> p.getInstanceId().equals(instanceId))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

}

