package com.yczuoxin.consulapplication.controller;

import com.yczuoxin.consulapplication.client.ConsulClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulController {

    @Autowired
    private ConsulClient consulClient;

    @GetMapping("hello")
    public String applicationDemo(){
        String demo = consulClient.demo();
        System.out.println("application has been used");
        return demo;
    }

}
