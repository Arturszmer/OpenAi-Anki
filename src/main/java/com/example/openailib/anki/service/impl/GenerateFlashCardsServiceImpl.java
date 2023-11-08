package com.example.openailib.anki.service.impl;

import com.example.openailib.anki.model.Card;
import com.example.openailib.anki.model.FlashCards;
import com.example.openailib.anki.service.GenerateFlashCardsService;
import com.example.openailib.model.ChatCompletionResponse;
import com.example.openailib.model.ChatFunction;
import com.example.openailib.model.FunctionCall;
import com.example.openailib.service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenerateFlashCardsServiceImpl implements GenerateFlashCardsService {

    private final ObjectMapper mapper;
    private final ChatService chatService;

    @Override
    public List<Card> fromText(String text, String languageLevel){
        try {
            ChatFunction chatFunction = mapper.readValue(new File("src/main/resources/templates/GenerateAnki.json"), ChatFunction.class);
            chatFunction.getParameters().put("language-level", languageLevel);

            ChatCompletionResponse response = chatService.generateFlashCardsFromAi(text, chatFunction);
            FunctionCall functionCall = response.getChoices().get(0).getMessage().getFunctionCall();
            FlashCards flashCards = mapper.readValue(functionCall.getArguments(), FlashCards.class);
            return flashCards.getFlashCards();
        } catch (Exception e){
            log.warn(e.getMessage());
        }
        return List.of();
    }
}
