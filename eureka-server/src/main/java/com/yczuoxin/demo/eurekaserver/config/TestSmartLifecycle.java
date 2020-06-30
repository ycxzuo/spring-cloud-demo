package com.yczuoxin.demo.eurekaserver.config;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * SmartLifecycle 测试
 */
@Component
public class TestSmartLifecycle implements SmartLifecycle {

    private boolean isRunning = false;

    /**
     * 1. 我们主要在该方法中启动任务或者其他异步服务，比如开启MQ接收消息
     * 2. 当上下文被刷新（所有对象已被实例化和初始化之后）时，将调用该方法，默认生命周期处理器将检查每个 SmartLifecycle
     * 对象的 isAutoStartup() 方法返回的布尔值。如果为 true，则该方法会被调用，而不是等待显式调用自己的 start() 方法。
     */
    @Override
    public void start() {
        System.out.println("start");

        // 执行完其他业务后，可以修改 isRunning = true
        isRunning = true;
    }

    /**
     * 如果工程中有多个实现接口 SmartLifecycle 的类，则这些类的 start 的执行顺序按 getPhase 方法返回值从小到大执行。
     * 例如：1 比 2 先执行，-1 比 0 先执行。 stop 方法的执行顺序则相反，getPhase 返回值较大类的 stop 方法先被调用，小的后被调用。
     */
    @Override
    public int getPhase() {
        // 默认为0
        return 0;
    }

    /**
     * 根据该方法的返回值决定是否执行 start 方法。
     * 返回 true 时 start 方法会被自动执行，返回 false 则不会。
     */
    @Override
    public boolean isAutoStartup() {
        // 默认为false
        return true;
    }

    /**
     * 1. 只有该方法返回 false 时，start 方法才会被执行。
     * 2. 只有该方法返回 true 时，stop(Runnable callback) 或 stop() 方法才会被执行。
     */
    @Override
    public boolean isRunning() {
        // 默认返回false
        return isRunning;
    }

    /**
     * SmartLifecycle 子类的才有的方法，当 isRunning 方法返回 true 时，该方法才会被调用。
     */
    @Override
    public void stop(Runnable callback) {
        System.out.println("stop(Runnable)");

        // 如果你让isRunning返回true，需要执行stop这个方法，那么就不要忘记调用callback.run()。
        // 否则在你程序退出时，Spring的DefaultLifecycleProcessor会认为你这个TestSmartLifecycle没有stop完成，程序会一直卡着结束不了，等待一定时间（默认超时时间30秒）后才会自动结束。
        // PS：如果你想修改这个默认超时时间，可以按下面思路做，当然下面代码是springmvc配置文件形式的参考，在SpringBoot中自然不是配置xml来完成，这里只是提供一种思路。
        // <bean id="lifecycleProcessor" class="org.springframework.context.support.DefaultLifecycleProcessor">
        //      <!-- timeout value in milliseconds -->
        //      <property name="timeoutPerShutdownPhase" value="10000"/>
        // </bean>
        callback.run();

        isRunning = false;
    }

    /**
     * 接口 Lifecycle 的子类的方法，只有非 SmartLifecycle 的子类才会执行该方法。
     * 1. 该方法只对直接实现接口 Lifecycle 的类才起作用，对实现 SmartLifecycle 接口的类无效。
     * 2. 方法 stop() 和方法 stop(Runnable callback) 的区别只在于，后者是 SmartLifecycle 子类的专属。
     */
    @Override
    public void stop() {
        System.out.println("stop");

        isRunning = false;
    }

}
