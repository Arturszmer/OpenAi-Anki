package com.example.openailib.integration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
public class OpenAiInterceptor implements RequestInterceptor {

    private final String API_KEY = System.getenv("OPENAI_TOKEN");

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(AUTHORIZATION, "Bearer " + API_KEY);
    }
}
