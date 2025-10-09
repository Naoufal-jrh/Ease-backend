package com.demo.trellolite.Mapper.Impl;

import com.demo.trellolite.Dto.ColumnDto;
import com.demo.trellolite.Entity.Column;
import com.demo.trellolite.Mapper.Mapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ColumnMapper implements Mapper<Column, ColumnDto> {
    private final ModelMapper modelMapper;

//    @PostConstruct
//    public void init() {
//        modelMapper.typeMap(Column.class, ColumnDto.class)
//                .addMapping(src -> src.getBoard().getId(), ColumnDto::setBoardId);
//    }

    @Override
    public ColumnDto mapTo(Column entity) {
        return modelMapper.map(entity, ColumnDto.class);
    }

    @Override
    public Column mapFrom(ColumnDto dto) {
        return modelMapper.map(dto, Column.class);
    }
}
