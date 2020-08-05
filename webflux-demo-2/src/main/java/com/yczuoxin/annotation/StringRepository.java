package com.yczuoxin.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface StringRepository {

    /**
     * 属性方法名称必须与 {@link Component#value()} 保持一致
     * @return
     */
    String value() default "";

}
