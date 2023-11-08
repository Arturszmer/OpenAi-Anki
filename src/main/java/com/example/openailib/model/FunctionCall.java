package com.example.openailib.model;

import lombok.Data;

@Data
public class FunctionCall {

    private String arguments;
    private String name;
}
