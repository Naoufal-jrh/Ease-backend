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
//        TODO: Implement member-specific boards retrieval
        System.out.println("get all boards");
        Member currentMember = ((MemberUserDetails) authentication.getPrincipal()).getMember();
        System.out.println("Current member: " + currentMember);
        List<BoardDto> boards = boardService.getCurrentMemberBoards(currentMember.getId());
        for(BoardDto board : boards) System.out.println("fetching all boards \nBoard: " + board);
        return boards;
    }


    @GetMapping("/{boardId}")
    public BoardDto getBoard(@PathVariable Long boardId, Authentication authentication){
//        TODO: Implement member-specific board retrieval
        Member currentMember = ((MemberUserDetails) authentication.getPrincipal()).getMember();
        BoardDto board = boardService.getBoardById(boardId, currentMember.getId());
        System.out.println("Retrieved board: " + board);
        return board;
    }

    @PostMapping
    public BoardDto addBoard(@RequestBody BoardDto board, Authentication authentication) {
        System.out.println("Authenticated user: " + authentication.getName());
        System.out.println("Board to add: " + board);
        Member currentMember = ((MemberUserDetails) authentication.getPrincipal()).getMember();
//        TODO: Implement member-specific board addition
//        return boardService.addBoard(board);
        return boardService.addBoard(board, currentMember);
    }
}
