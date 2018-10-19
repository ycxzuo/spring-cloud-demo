package com.yczuoxin.consulclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulClientController {

    @GetMapping("/demo/{str}")
    public String demo(@PathVariable("str") String str){
        System.out.println("consul-client");
        return "Hello World " + str;
    }
}
