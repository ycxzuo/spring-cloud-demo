package com.yczuoxin.webcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebContextApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebContextApplication.class, args);
    }

}
