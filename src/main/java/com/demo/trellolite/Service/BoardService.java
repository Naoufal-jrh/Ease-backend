package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.BoardDto;

import java.util.List;
import java.util.NoSuchElementException;

public interface BoardService {
    BoardDto getBoardById(Long boardId) throws NoSuchElementException;
    List<BoardDto> getAllBoards();
    BoardDto addBoard(BoardDto board);
}
