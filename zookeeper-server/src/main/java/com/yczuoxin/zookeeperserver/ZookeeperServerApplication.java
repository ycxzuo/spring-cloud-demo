package com.yczuoxin.zookeeperserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperServerApplication.class, args);
    }

}
