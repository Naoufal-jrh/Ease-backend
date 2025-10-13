package com.demo.trellolite.Controller;


import com.demo.trellolite.Dto.CardDto;
import com.demo.trellolite.Service.CardService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CardController {
    private final CardService cardService;

    @PostMapping
    public CardDto addCard(@RequestBody CardDto card, @PathParam("") Long columnId) {
        return cardService.addCard(columnId, card);
    }

    @PutMapping("/toColumn/{columnId}")
    public List<CardDto> addCardsToColumn(@PathVariable Long columnId, @RequestBody List<CardDto> cards) {
        return cardService.saveCards(columnId, cards);
    }
}
