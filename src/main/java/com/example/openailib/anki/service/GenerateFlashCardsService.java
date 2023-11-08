package com.example.openailib.anki.service;

import com.example.openailib.anki.model.Card;

import java.util.List;

public interface GenerateFlashCardsService {

    List<Card> fromText(String text, String languageLevel);
}
