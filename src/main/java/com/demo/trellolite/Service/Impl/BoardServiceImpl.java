package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.BoardDto;
import com.demo.trellolite.Entity.Board;
import com.demo.trellolite.Mapper.Impl.BoardMapper;
import com.demo.trellolite.Mapper.Impl.ColumnMapper;
import com.demo.trellolite.Repository.BoardRepository;
import com.demo.trellolite.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;
    private final ColumnMapper columnMapper;

    @Override
    public BoardDto getBoardById(Long boardId) {
        return boardRepository.findById(boardId)
                .map(boardMapper::mapTo)
                .orElseThrow();
    }

    @Override
    public BoardDto updateBoardFields(Long boardId, BoardDto boardDto) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        if(boardDto.getColumns() != null) board.setColumns(boardDto.getColumns().stream().map(columnMapper::mapFrom).collect(Collectors.toList()));
        return boardMapper.mapTo(boardRepository.save(board));

    }
}
