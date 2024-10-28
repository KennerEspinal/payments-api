package com.kendev.infrastructure.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Data;

@ConfigurationProperties("db")
@Data
public class DatabaseConfig {
    private String url;
    private String username;
    private String password;
}
