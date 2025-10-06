package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.CardDto;
import com.demo.trellolite.Mapper.Impl.CardMapper;
import com.demo.trellolite.Repository.CardRepository;
import com.demo.trellolite.Service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    public CardDto createCard(CardDto cardDto) {
        return cardMapper.mapTo(
                cardRepository.save(
                        cardMapper.mapFrom(cardDto)
                )
        );
    }
}
