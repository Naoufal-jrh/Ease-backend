package com.demo.trellolite.Controller;

import com.demo.trellolite.Dto.MemberDto;
import com.demo.trellolite.Entity.Member;
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
        MemberDto memberDto = memberService.me();
        System.out.println("memeber dto : "+memberDto);
        return memberDto;
    }

    @GetMapping
    public List<MemberDto> allMembers() {
        return memberService.allMembers();
    }

}
