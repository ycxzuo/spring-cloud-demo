package com.yczuoxin.consulapplication.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("consul-service")
public interface ConsulClient {

    @GetMapping(value = "/demo")
    String demo();

}
