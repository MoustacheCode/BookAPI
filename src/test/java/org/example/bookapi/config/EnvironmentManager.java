package org.example.bookapi.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentManager {

    @Value("${base.url}")
    private String baseUrl;

    public String baseUrl() {
        return baseUrl;
    }

}