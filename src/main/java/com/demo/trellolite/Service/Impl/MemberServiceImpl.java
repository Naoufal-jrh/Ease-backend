package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.MemberDto;
import com.demo.trellolite.Entity.Member;
import com.demo.trellolite.Mapper.Impl.MemberMapper;
import com.demo.trellolite.Repository.MemberRepository;
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
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            MemberUserDetails currentMemberUD = (MemberUserDetails) authentication.getPrincipal();
            System.out.println(currentMemberUD);
            Long memberId = currentMemberUD.getMember().getId();
            // refetching the memeber because the one in principle do not hold the list of boards
            return memberMapper.mapTo(memberRepository.findById(memberId).orElseThrow());
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
