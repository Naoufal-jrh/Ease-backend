package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.ColumnDto;

import java.util.List;

public interface ColumnService {
    ColumnDto addColumn(Long boardId , ColumnDto columnDto);
    List<ColumnDto> addColumns(Long boardId, List<ColumnDto> columns);
}
