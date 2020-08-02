package com.yczuoxin.webfluxdemo2;

import com.yczuoxin.config.WebConfiguration;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

//@SpringBootApplication(scanBasePackages = "com.yczuoxin.config")
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
public class WebfluxDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(WebConfiguration.class, args);
    }

//    @Bean
//    public ApplicationRunner runner(WebServerApplicationContext context) {
//        return args -> System.out.println("当前 WebServer 实现类为" + context.getWebServer().getClass().getName());
//    }

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("WebfluxDemo2Application: 当前 WebServer 实现类为" + event.getWebServer().getClass().getName());
    }

}
