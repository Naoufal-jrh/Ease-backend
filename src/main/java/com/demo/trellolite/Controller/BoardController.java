package com.demo.trellolite.Controller;


import com.demo.trellolite.Dto.BoardDto;
import com.demo.trellolite.Entity.Board;
import com.demo.trellolite.Entity.Member;
import com.demo.trellolite.Service.BoardService;
import com.demo.trellolite.securityUtils.MemberUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {
    private final BoardService boardService;


    @GetMapping
    public List<BoardDto> getAllBoards(Authentication authentication) {
        Member currentMember = ((MemberUserDetails) authentication.getPrincipal()).getMember();
        return boardService.getCurrentMemberBoards(currentMember.getId());
    }


    @GetMapping("/{boardId}")
    public BoardDto getBoard(@PathVariable Long boardId, Authentication authentication){
        Member currentMember = ((MemberUserDetails) authentication.getPrincipal()).getMember();
        return boardService.getBoardById(boardId, currentMember.getId());
    }

    @PostMapping
    public BoardDto addBoard(@RequestBody BoardDto board, Authentication authentication) {
        Member currentMember = ((MemberUserDetails) authentication.getPrincipal()).getMember();
        return boardService.addBoard(board, currentMember);
    }
}
