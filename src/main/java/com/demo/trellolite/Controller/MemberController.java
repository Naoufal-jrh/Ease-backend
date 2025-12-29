package com.demo.trellolite.Controller;

import com.demo.trellolite.Dto.MemberDto;
import com.demo.trellolite.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/me")
    public MemberDto me() {
        return memberService.me();
    }

    @GetMapping
    public List<MemberDto> allMembers() {
        return memberService.allMembers();
    }

}
