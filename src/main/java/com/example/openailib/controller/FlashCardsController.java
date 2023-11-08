package com.example.openailib.controller;

import com.example.openailib.anki.model.Card;
import com.example.openailib.anki.service.GenerateFlashCardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/anki")
public class FlashCardsController {

    private final GenerateFlashCardsService service;

    @PostMapping(value = "/generate", consumes = MediaType.TEXT_PLAIN_VALUE)
    ResponseEntity<List<Card>> generateFromText(@RequestParam("languageLevel") String languageLevel, @RequestBody String text){
        return ResponseEntity.ok(service.fromText(text, languageLevel));
    }
}
