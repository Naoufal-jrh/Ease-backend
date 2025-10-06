package com.demo.trellolite.Mapper.Impl;

import com.demo.trellolite.Dto.ColumnDto;
import com.demo.trellolite.Entity.Column;
import com.demo.trellolite.Mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ColumnMapper implements Mapper<Column, ColumnDto> {
    private final ModelMapper modelMapper;

    @Override
    public ColumnDto mapTo(Column entity) {
        return modelMapper.map(entity, ColumnDto.class);
    }

    @Override
    public Column mapFrom(ColumnDto dto) {
        return modelMapper.map(dto, Column.class);
    }
}
