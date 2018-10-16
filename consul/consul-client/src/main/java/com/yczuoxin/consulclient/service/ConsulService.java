package com.yczuoxin.consulclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("consul-service")
public interface ConsulService {

    @GetMapping("/demo")
    String demo();

}
