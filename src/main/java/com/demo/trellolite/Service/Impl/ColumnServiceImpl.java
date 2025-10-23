package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.ColumnDto;
import com.demo.trellolite.Entity.Board;
import com.demo.trellolite.Entity.Column;
import com.demo.trellolite.Mapper.Impl.ColumnMapper;
import com.demo.trellolite.Repository.ColumnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.demo.trellolite.Service.ColumnService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ColumnServiceImpl implements ColumnService {
    private final ColumnRepository columnRepository;
    private final ColumnMapper columnMapper;

    @Override
    public ColumnDto addColumn(Long boardId , ColumnDto columnDto) {
        Column column = columnMapper.mapFrom(columnDto);
        column.setBoard(
                Board.builder().id(boardId).build()
        );
        return columnMapper.mapTo(columnRepository.save(column));
    }

    @Override
    public List<ColumnDto> addColumns(Long boardId, List<ColumnDto> columns) {
        List<Column> oldColumnsList = columnRepository.findByBoardId(boardId);
        Map<Long, Column> oldColumnsMap = new HashMap<>();
        for(Column col : oldColumnsList) oldColumnsMap.put(col.getId(), col);

        for(int i = 0; i < columns.size(); i++) {
            ColumnDto c = columns.get(i);
            oldColumnsMap.get(c.getId()).setPosition(i+1);
        }

        return ((List<Column>) columnRepository.saveAll(oldColumnsMap.values())).stream().map(columnMapper::mapTo).toList();

    }

}
