package com.yczuoxin.demo.eurekaserver;

import com.yczuoxin.demo.eurekaserver.config.TestLifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class LifecycleApplication {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(TestLifecycle.class);
        context.start();
        context.close();
    }
}
