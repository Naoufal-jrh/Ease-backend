package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.BoardDto;

public interface BoardService {
    BoardDto getBoardById(Long boardId);
    BoardDto updateBoardFields(Long boardId, BoardDto boardDto);
}
