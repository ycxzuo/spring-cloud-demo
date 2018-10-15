package com.yczuoxin.consulclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulController {

    @GetMapping("/demo")
    public String demo(){
        return "Hello World";
    }
}
