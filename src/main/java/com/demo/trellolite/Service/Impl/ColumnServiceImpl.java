package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.BoardDto;
import com.demo.trellolite.Dto.CardDto;
import com.demo.trellolite.Dto.ColumnDto;
import com.demo.trellolite.Entity.Board;
import com.demo.trellolite.Entity.Column;
import com.demo.trellolite.Mapper.Impl.CardMapper;
import com.demo.trellolite.Mapper.Impl.ColumnMapper;
import com.demo.trellolite.Repository.BoardRepository;
import com.demo.trellolite.Repository.ColumnRepository;
import com.demo.trellolite.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.demo.trellolite.Service.ColumnService;
import com.demo.trellolite.Service.CardService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColumnServiceImpl implements ColumnService {
    private final ColumnRepository columnRepository;
    private final ColumnMapper columnMapper;
    private final CardMapper cardMapper;
    private final CardService cardService;
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @Override
    public ColumnDto addColumn(Long boardId , ColumnDto columnDto) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        Column col = columnRepository.save(columnMapper.mapFrom(columnDto));

        List<Column> newColumns = new ArrayList<>(board.getColumns());
        newColumns.add(col);

        board.setColumns(newColumns);
        boardRepository.save(board);
        return columnMapper.mapTo(col);
    }

    @Override
    public ColumnDto addCardToColumn(Long columnId, CardDto cardDto) {
        // create the card first
        CardDto newCard = cardService.createCard(cardDto);
        // add card to column
        Column column = columnRepository.findById(columnId).orElseThrow();
        column.getCards().add(
                cardMapper.mapFrom(
                        newCard
                )
        );
        return columnMapper.mapTo(
                columnRepository.save(column)
        );
    }

    @Override
    public ColumnDto updateColumnFields(Long columnId, ColumnDto columnDto) {
        Column column = columnRepository.findById(columnId).orElseThrow();
        if(columnDto.getCards() != null) column.setCards(columnDto.getCards().stream().map(cardMapper::mapFrom).collect(Collectors.toList()));
        return columnMapper.mapTo(columnRepository.save(column));
    }
}
