package com.example.openailib.service;

import com.example.openailib.CustomUtils;
import com.example.openailib.integration.OpenAiIntegration;
import com.example.openailib.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.openailib.model.ChatModel.GPT4_1106_PREVIEW;
import static com.example.openailib.model.OpenAiRoles.SYSTEM;
import static com.example.openailib.model.OpenAiRoles.USER;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatService {

    private final OpenAiIntegration openAiApi;

    public String englishImprover(ChatMessage userMessage) {

        try {
            String systemContent = CustomUtils.readMarkdownFile("templates/grammatical-improvement.md");
            ChatMessage systemMessage = new ChatMessage(systemContent, SYSTEM.getRole());

            ChatCompletionRequest request = ChatCompletionRequest.builder()
                    .model(GPT4_1106_PREVIEW.getModel())
                    .messages(List.of(systemMessage, userMessage))
                    .maxTokens(2000)
                    .temperature(0.2)
                    .build();
            ChatCompletionResponse chat = openAiApi.chat(request);
            String response = chat.getChoices().get(0).getMessage().getContent();
            System.out.println(response);
            return response;
        } catch (Exception e){
            log.warn(e.getMessage());
            System.out.println("Something went wrong! Chat is not working");
        }
        return "";
    }

    public ChatCompletionResponse conversation(ChatMessage chatMessage) {

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model(GPT4_1106_PREVIEW.getModel())
                .messages(List.of(chatMessage))
                .maxTokens(5000)
                .temperature(1.0)
                .build();
        return openAiApi.chat(request);
    }

    public ChatCompletionResponse generateFlashCardsFromAi(String content, ChatFunction function){
        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model(GPT4_1106_PREVIEW.getModel())
                .messages(List.of(new ChatMessage(content, USER.getRole())))
                .functionCall("auto")
                .functions(List.of(function))
                .maxTokens(3000)
                .temperature(0.5)
                .build();
        return openAiApi.chat(request);
    }
}
