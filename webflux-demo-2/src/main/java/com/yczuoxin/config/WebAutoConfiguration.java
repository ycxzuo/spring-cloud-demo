package com.yczuoxin.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ConditionalOnWebApplication
@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {



}
