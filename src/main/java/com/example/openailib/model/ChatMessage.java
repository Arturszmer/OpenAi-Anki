package com.example.openailib.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatMessage {


    private String content;
    @JsonProperty(value = "function_call")
    private FunctionCall functionCall;
    private String role;

    public ChatMessage(String content, String role) {
        this.content = content;
        this.role = role;
    }
}
