package com.example.openailib.model;

import lombok.Getter;

@Getter
public enum OpenAiRoles {
    SYSTEM("system"),
    USER("user"),
    ASSISTANT("assistant");

    private final String role;

    OpenAiRoles(String role) {
        this.role = role;
    }
}
