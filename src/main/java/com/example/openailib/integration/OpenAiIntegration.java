package com.example.openailib.integration;


import com.example.openailib.model.ChatCompletionRequest;
import com.example.openailib.model.ChatCompletionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(value = "OpenAi", url = "https://api.openai.com")
public interface OpenAiIntegration {

    @PostMapping("/v1/chat/completions")
    ChatCompletionResponse sayHello(@RequestHeader Map<String, ?> headers, @RequestBody ChatCompletionRequest request);

    @PostMapping(value = "/v1/chat/completions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ChatCompletionResponse chat(@RequestBody ChatCompletionRequest request);
//
//    @PostMapping("/v1/moderations")
//    ModerationResponse moderation(@RequestBody ModerationRequest request);
//
//    @PostMapping("/v1/embeddings")
//    EmbeddingResponse embedding(@RequestHeader Map<String, ?> headers, @RequestBody EmbeddingRequest request);
//
//    @PostMapping(value = "/v1/audio/transcriptions", headers = {"Content-Type=multipart/form-data"})
//    TranscriptResponse transcriptAudio(@ModelAttribute WhisperTranscriptionRequest request);
}
