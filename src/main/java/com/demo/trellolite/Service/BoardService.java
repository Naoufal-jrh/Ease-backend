package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.BoardDto;

import java.util.List;

public interface BoardService {
    BoardDto getBoardById(Long boardId);
    BoardDto updateBoardFields(Long boardId, BoardDto boardDto);
    List<BoardDto> getAllBoards();

    BoardDto addBoard(BoardDto board);
}
