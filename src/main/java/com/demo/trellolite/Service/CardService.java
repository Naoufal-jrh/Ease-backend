package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.CardDto;

import java.util.List;

public interface CardService {
    CardDto addCard(Long columnId, CardDto card);
    List<CardDto> addCards(Long columnId, List<CardDto> cards);
}
