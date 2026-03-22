package com.yczuoxin.webfluxdemo1.configuration;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

    @Bean
    ConnectionFactory connectionFactory() {
        return MySqlConnectionFactory.from(MySqlConnectionConfiguration.builder()
                .host("47.106.127.193")
                .port(3306)
                .username("root")
                .password(System.getenv().getOrDefault("DB_PASSWORD", "root"))
                .database("user")
                .build());
    }

}
