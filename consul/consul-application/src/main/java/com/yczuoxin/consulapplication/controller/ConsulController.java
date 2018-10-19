package com.yczuoxin.consulapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsulController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RestController
    public class TestController{

        private final RestTemplate restTemplate;

        @Autowired
        public TestController(RestTemplate restTemplate){
            this.restTemplate = restTemplate;
        }

        @GetMapping("/demo/{str}")
        public String demo(@PathVariable String str){
            System.out.println("consul-application");
            return restTemplate.getForObject("http://consul-client/demo/"+str,String.class);
        }

    }

}
