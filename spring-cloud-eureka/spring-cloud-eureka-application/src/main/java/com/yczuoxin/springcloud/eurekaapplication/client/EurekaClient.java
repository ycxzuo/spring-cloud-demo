package com.yczuoxin.springcloud.eurekaapplication.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-service")
public interface EurekaClient {

    @RequestMapping
    String demo();
}
