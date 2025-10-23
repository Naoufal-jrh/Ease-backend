package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.CardDto;
import com.demo.trellolite.Entity.Card;
import com.demo.trellolite.Entity.Column;
import com.demo.trellolite.Mapper.Impl.CardMapper;
import com.demo.trellolite.Repository.CardRepository;
import com.demo.trellolite.Service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    @Transactional
    public CardDto addCard(Long columnId, CardDto cardDto) {
        Card card = cardMapper.mapFrom(cardDto);
        card.setColumn(
                Column.builder()
                        .id(columnId)
                        .build()
        );
        return cardMapper.mapTo(
                cardRepository.save(
                        card
                )
        );
    }

    @Override
    @Transactional
    public List<CardDto> addCards(Long columnId, List<CardDto> cards) {
        // hibernate does a select query for each card !! inorder to do the merge function.
        // then he does an update query for each card, even if it was not changed.
        // this may cause a performance issue later.
        // NOTE : the cards sent by the front-end only have id and description attributes, no position att is being sent.
        // we can try to do this manually, get all the cards of the column, then find out what was changed, and do the updates yourself

        List<Card> cardEntities = cards.stream().map(crd -> {
            Card c = cardMapper.mapFrom(crd);
            c.setColumn(
                    Column.builder().id(columnId).build()
            );
            return c;
        }).toList();

        for(int i = 1; i <= cardEntities.size(); i++){
            cardEntities.get(i-1).setPosition(i);
        }


        return ((List<Card>)cardRepository.saveAll(cardEntities)).stream().map(cardMapper::mapTo).toList();
    }
}
