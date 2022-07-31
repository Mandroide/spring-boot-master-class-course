package com.example.demo.infoapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "info.app")
@Configuration
@lombok.Data
public class InfoApp {
    private String name;
    private String description;
    private String version;
}
