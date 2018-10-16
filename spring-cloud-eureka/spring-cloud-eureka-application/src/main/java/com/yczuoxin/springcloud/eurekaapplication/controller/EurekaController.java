package com.yczuoxin.springcloud.eurekaapplication.controller;

import com.yczuoxin.springcloud.eurekaapplication.client.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {

    @Autowired
    EurekaClient client;

    @GetMapping("/demo")
    public String demo(){
        return client.demo();
    }
}
