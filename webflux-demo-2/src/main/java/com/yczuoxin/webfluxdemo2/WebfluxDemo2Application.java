package com.yczuoxin.webfluxdemo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.yczuoxin.config")
public class WebfluxDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxDemo2Application.class, args);
    }

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        log.info("当前 WebServer 实现类为 {}", event.getWebServer().getClass().getName());
    }

}
