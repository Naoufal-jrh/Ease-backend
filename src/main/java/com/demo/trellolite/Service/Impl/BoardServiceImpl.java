package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.BoardDto;
import com.demo.trellolite.Mapper.Impl.BoardMapper;
import com.demo.trellolite.Repository.BoardRepository;
import com.demo.trellolite.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Override
    public BoardDto getBoardById(Long boardId) {
        return boardRepository.findById(boardId)
                .map(boardMapper::mapTo)
                .orElseThrow();
    }
}
