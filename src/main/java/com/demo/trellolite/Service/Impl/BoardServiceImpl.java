package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.BoardDto;
import com.demo.trellolite.Entity.Board;
import com.demo.trellolite.Mapper.Impl.BoardMapper;
import com.demo.trellolite.Repository.BoardRepository;
import com.demo.trellolite.Service.BoardService;
import com.demo.trellolite.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.MappingException;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Override
    public BoardDto getBoardById(Long boardId, Long memberId) {
        Board board = boardRepository.findByIdAndOwnerId(boardId, memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Board", "id", boardId));
        return boardMapper.mapTo(board);
    }

    @Override
    public List<BoardDto> getAllBoards() {
        return boardRepository.findAllBoards().stream()
                .map(boardMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<BoardDto> getCurrentMemberBoards(Long memberId) {
        return boardRepository.findByOwnerId(memberId).stream()
                .map(boardMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BoardDto addBoard(BoardDto boardDto) {
        // it is transactional in case the mapping failed
        Board board = boardMapper.mapFrom(boardDto);
        Board savedBoard = boardRepository.save(board);
        return boardMapper.mapTo(savedBoard);
    }
}
