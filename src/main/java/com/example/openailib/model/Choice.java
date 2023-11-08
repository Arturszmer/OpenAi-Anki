package com.example.openailib.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Choice {

    @JsonProperty(value = "finish_reason")
    private String finishReason;
    private int index;
    private ChatMessage message;
}
