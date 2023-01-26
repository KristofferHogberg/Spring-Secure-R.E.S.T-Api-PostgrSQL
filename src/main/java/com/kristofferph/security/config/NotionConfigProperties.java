package com.kristofferph.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("notion")
public record NotionConfigProperties(String secretKey, String databaseUrl, String username, String password) {
}
