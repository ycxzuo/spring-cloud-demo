package com.yczuoxin.demo.eurekaserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/close")
    public void close(){
        System.out.println("closing");
        // 测试
        System.exit(0);
    }

}
