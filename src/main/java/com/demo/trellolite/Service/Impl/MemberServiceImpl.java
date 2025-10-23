package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.MemberDto;
import com.demo.trellolite.Entity.Member;
import com.demo.trellolite.Mapper.Impl.MemberMapper;
import com.demo.trellolite.Repository.MemberRepository;
import com.demo.trellolite.Service.AuthenticationService;
import com.demo.trellolite.Service.MemberService;
import com.demo.trellolite.securityUtils.MemberUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;


    @Override
    public MemberDto me() {
        // just make this transactional to keep the session open
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            MemberUserDetails currentMemberUD = (MemberUserDetails) authentication.getPrincipal();
            System.out.println(currentMemberUD);
            Member member = currentMemberUD.getMember();
            member.setBoards(List.of());
            return memberMapper.mapTo(member);
        } catch (Exception e){
            System.out.println("exception in me()");
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<MemberDto> allMembers() {
        return ((List<Member>) memberRepository.findAll()).stream().map(memberMapper::mapTo).toList();
    }
}
