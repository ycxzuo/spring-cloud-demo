package com.yczuoxin.ncaosserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NcaosServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NcaosServerApplication.class, args);
    }

}
