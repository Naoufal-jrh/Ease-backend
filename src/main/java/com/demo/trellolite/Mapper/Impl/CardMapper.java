package com.demo.trellolite.Mapper.Impl;


import com.demo.trellolite.Dto.CardDto;
import com.demo.trellolite.Entity.Card;
import com.demo.trellolite.Mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardMapper implements Mapper<Card, CardDto> {
    private final ModelMapper modelMapper;


    @Override
    public CardDto mapTo(Card entity) {
        return modelMapper.map(entity,CardDto.class);
    }

    @Override
    public Card mapFrom(CardDto dto) {
        return modelMapper.map(dto, Card.class);
    }
}
