package com.yczuoxin.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApplication.class, args);
    }

    @Bean
    public EnvironmentRepository myEnvironmentRepository(){
        return (String application, String profile, String label) -> {
            Environment environment = new Environment("default", profile);
            environment.setLabel(label);
            environment.setState("ON");
            environment.setVersion("1.0.0");
            List<PropertySource> propertySources = environment.getPropertySources();
            Map<String, String> resource = new HashMap<>(1);
            resource.put("name","yczuoxin");
            PropertySource propertySource =new PropertySource("source",resource);
            propertySources.add(propertySource);
            return environment;
        };
    }
}
