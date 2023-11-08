package com.example.openailib.model;

import lombok.Getter;

@Getter
public enum ChatModel {

    GPT4("gpt-4"),
    GPT4_1106_PREVIEW("gpt-4-1106-preview"),
    GPT4_0613("gpt-4-0613"),
    GPT4_32K("gpt-4-32k"),
    GPT4_32K_0613("gpt-4-32k-0613"),
    GPT3_5_TURBO("gpt-3.5-turbo"),
    GPT3_5_TURBO_0613("gpt-3.5-turbo-0613"),
    GPT3_5_TURBO_16K("gpt-3.5-turbo-16k"),
    GPT3_5_TURBO_16K_0613("gpt-3.5-turbo-16k-0613");

    private final String model;

    ChatModel(String model) {
        this.model = model;
    }
}
