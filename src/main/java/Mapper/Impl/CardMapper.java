package Mapper.Impl;


import Dto.CardDto;
import Entity.Card;
import Mapper.Mapper;
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
