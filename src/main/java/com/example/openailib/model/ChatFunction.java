package com.example.openailib.model;

import lombok.Data;

import java.util.Map;

@Data
public class ChatFunction {

    private String name;
    private String description;
    // could be custom, ex. type, properties, required
    private Map<String, Object> parameters;
}
