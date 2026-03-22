package com.yczuoxin.demo.eurekaserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestSmartLifecycle implements SmartLifecycle {

    private volatile boolean isRunning = false;

    @Override
    public void start() {
        log.info("SmartLifecycle is start");
        isRunning = true;
    }

    @Override
    public int getPhase() {
        return 0;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void stop(Runnable callback) {
        log.info("SmartLifecycle is stop(Runnable) starting");
        callback.run();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("SmartLifecycle stop interrupted", e);
        }
        log.info("SmartLifecycle is stop(Runnable) completed");
        callback.run();
        isRunning = false;
    }

    @Override
    public void stop() {
        log.info("SmartLifecycle is stop");
        isRunning = false;
    }

}
