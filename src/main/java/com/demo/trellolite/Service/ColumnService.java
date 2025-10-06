package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.CardDto;
import com.demo.trellolite.Dto.ColumnDto;

public interface ColumnService {
    ColumnDto addCardToColumn(Long columnId, CardDto cardDto);
}
