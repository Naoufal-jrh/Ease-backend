package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.CardDto;
import com.demo.trellolite.Dto.ColumnDto;

public interface ColumnService {
    ColumnDto addColumn(Long boardId , ColumnDto columnDto);
    ColumnDto addCardToColumn(Long columnId, CardDto cardDto);
    ColumnDto updateColumnFields(Long columnId, ColumnDto columnDto);
}
