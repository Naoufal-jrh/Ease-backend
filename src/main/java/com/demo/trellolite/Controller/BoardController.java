package com.demo.trellolite.Controller;


import com.demo.trellolite.Dto.BoardDto;
import com.demo.trellolite.Entity.Board;
import com.demo.trellolite.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {
    private final BoardService boardService;


    @GetMapping
    public List<BoardDto> getAllBoards() {
        return boardService.getAllBoards();
    }


    @GetMapping("/{boardId}")
    public BoardDto getBoard(@PathVariable Long boardId){
        return boardService.getBoardById(boardId);
    }

    @PostMapping
    public BoardDto addBoard(@RequestBody BoardDto board) {
        System.out.println("adding board "+board);
        return boardService.addBoard(board);
    }
}
