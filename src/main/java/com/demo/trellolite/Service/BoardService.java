package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.BoardDto;

import java.util.List;

public interface BoardService {
    BoardDto getBoardById(Long boardId);
    List<BoardDto> getAllBoards();
    BoardDto addBoard(BoardDto board);
}
