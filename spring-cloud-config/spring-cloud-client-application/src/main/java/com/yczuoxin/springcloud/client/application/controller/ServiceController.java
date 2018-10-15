package com.yczuoxin.springcloud.client.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: spring-cloud-demo
 * @description:
 * @author: yczuoxin
 * @create: 2018-08-18 10:26
 **/
@RestController
public class ServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/services")
    public List<String> getAllService(){
        return discoveryClient.getServices();
    }

    @GetMapping("/service/instance/{serviceId}")
    public List<String> getServiceById(@PathVariable("serviceId") String serviceId){
        return discoveryClient.getInstances(serviceId).stream()
                .map(serviceInstance -> serviceInstance.getServiceId() + "->" + serviceInstance.getHost() + ":" + serviceInstance.getPort())
                .distinct()
                .collect(Collectors.toList());
    }


}
