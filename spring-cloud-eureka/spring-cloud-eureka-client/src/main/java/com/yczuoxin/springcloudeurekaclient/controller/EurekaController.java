package com.yczuoxin.springcloudeurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {

    @GetMapping("/demo")
    public String demo(){
        return "Hello, World";
    }
}
