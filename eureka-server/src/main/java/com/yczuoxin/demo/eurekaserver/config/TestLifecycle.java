package com.yczuoxin.demo.eurekaserver.config;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

//@Component
public class TestLifecycle implements Lifecycle {

    private static volatile boolean isRunning = false;

    @Override
    public void start() {
        System.out.println("lifecycle is start");
        isRunning = true;
    }

    @Override
    public void stop() {
        System.out.println("lifecycle is stop");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
