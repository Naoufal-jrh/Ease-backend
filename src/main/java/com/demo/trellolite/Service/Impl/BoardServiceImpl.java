package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.BoardDto;
import com.demo.trellolite.Entity.Board;
import com.demo.trellolite.Mapper.Impl.BoardMapper;
import com.demo.trellolite.Mapper.Impl.ColumnMapper;
import com.demo.trellolite.Repository.BoardRepository;
import com.demo.trellolite.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Override
    public BoardDto getBoardById(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow();
        return boardMapper.mapTo(board);
    }

    @Override
    public List<BoardDto> getAllBoards() {
        // do not fetch the list of columns
        return (boardRepository.findAllBoards()).stream().map(boardMapper::mapTo).collect(Collectors.toList());
    }

    @Override
    public BoardDto addBoard(BoardDto board) {
        return boardMapper.mapTo(boardRepository.save(boardMapper.mapFrom(board)));
    }
}
