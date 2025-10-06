package com.demo.trellolite.Controller;


import com.demo.trellolite.Dto.BoardDto;
import com.demo.trellolite.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/{boardId}")
    public BoardDto getBoard(@PathVariable Long boardId){
        return boardService.getBoardById(boardId);
    }
}
