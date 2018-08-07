package com.yczuoxin.springcloud.discovery.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudDiscoveryClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDiscoveryClientApplication.class, args);
    }
}
