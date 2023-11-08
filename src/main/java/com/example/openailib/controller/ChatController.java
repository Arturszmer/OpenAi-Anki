package com.example.openailib.controller;

import com.example.openailib.model.ChatCompletionResponse;
import com.example.openailib.model.ChatMessage;
import com.example.openailib.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/chat")
    public ResponseEntity<ChatCompletionResponse> chat(@RequestBody ChatMessage message){
        return ResponseEntity.ok(chatService.conversation(message));
    }
}
