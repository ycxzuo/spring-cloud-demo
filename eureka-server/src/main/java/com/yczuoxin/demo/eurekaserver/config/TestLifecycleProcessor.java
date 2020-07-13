package com.yczuoxin.demo.eurekaserver.config;

import org.springframework.context.support.DefaultLifecycleProcessor;
import org.springframework.stereotype.Component;

@Component(value = "lifecycleProcessor")
public class TestLifecycleProcessor extends DefaultLifecycleProcessor {

    @Override
    public void onRefresh() {
        System.out.println("TestLifecycleProcessor onRefresh");
        super.onRefresh();
    }

    @Override
    public void onClose() {
        System.out.println("TestLifecycleProcessor onClose");
        super.onClose();
    }

    @Override
    public void start() {
        System.out.println("TestLifecycleProcessor start");
        super.start();
    }

    @Override
    public void stop() {
        System.out.println("TestLifecycleProcessor stop");
        super.stop();
    }

    @Override
    public boolean isRunning() {
        System.out.println("TestLifecycleProcessor isRunning");
        return super.isRunning();
    }
}
