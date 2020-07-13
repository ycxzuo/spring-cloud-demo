package com.yczuoxin.demo.eurekaserver.config;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class TestSmartLifecycle2 implements SmartLifecycle {

    private boolean isRunning = false;

    @Override
    public void start() {
        System.out.println("SmartLifecycle2 is start");
        isRunning = true;
    }

    @Override
    public int getPhase() {
        // 默认为0
        return 2;
    }

    @Override
    public boolean isAutoStartup() {
        // 默认为 true
        return true;
    }

    @Override
    public boolean isRunning() {
        // 默认返回false
        return isRunning;
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("SmartLifecycle2 is stop(Runnable) ing");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SmartLifecycle2 is stop(Runnable)");
        callback.run();

        isRunning = false;
    }

    @Override
    public void stop() {
        System.out.println("SmartLifecycle2 is stop");
        isRunning = false;
    }

}
