package com.example.openailib.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatCompletionRequest {


    @JsonProperty("model")
    private String model;
    private List<ChatMessage> messages;
    @JsonProperty("fequency_penalty")
    private Double frequencyPenalty;
    @JsonProperty("function_call")
    private String functionCall;
    private List<ChatFunction> functions;
    @JsonProperty("logit_bias")
    private Map<String, Integer> logitBias;
    @JsonProperty("max_tokens")
    private Integer maxTokens;
    private Integer n;
    @JsonProperty("presence_penalty")
    private Double presencePenalty;
    private Object stop;
    @JsonProperty("stream")
    private Boolean stream;
    private Double temperature;
    private Double topP;
    private String user;
}
