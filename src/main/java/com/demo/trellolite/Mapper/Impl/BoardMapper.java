package com.demo.trellolite.Mapper.Impl;

import com.demo.trellolite.Dto.BoardDto;
import com.demo.trellolite.Entity.Board;
import com.demo.trellolite.Mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardMapper implements Mapper<Board, BoardDto> {
    private final ModelMapper modelMapper;

    @Override
    public BoardDto mapTo(Board entity) {
        return modelMapper.map(entity, BoardDto.class);
    }

    @Override
    public Board mapFrom(BoardDto dto) {
        return modelMapper.map(dto, Board.class);
    }
}
