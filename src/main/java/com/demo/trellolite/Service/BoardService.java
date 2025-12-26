package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.BoardDto;
import com.demo.trellolite.Entity.Member;

import java.util.List;
import java.util.NoSuchElementException;

public interface BoardService {
    BoardDto getBoardById(Long boardId, Long memberId) throws NoSuchElementException;
    List<BoardDto> getAllBoards();
    List<BoardDto> getCurrentMemberBoards(Long memberId);
    BoardDto addBoard(BoardDto board);
    BoardDto addBoard(BoardDto board, Member member);
}
