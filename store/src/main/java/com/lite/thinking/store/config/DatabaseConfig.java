package com.lite.thinking.store.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Value("${SPRING_DATASOURCE_URL}")
    private String dbUrl;

    @Value("${SPRING_DATASOURCE_USERNAME}")
    private String dbUsername;

    @Value("${SPRING_DATASOURCE_PASSWORD}")
    private String dbPassword;

}
