package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.MemberDto;
import com.demo.trellolite.Entity.Member;
import com.demo.trellolite.Mapper.Impl.MemberMapper;
import com.demo.trellolite.Repository.MemberRepository;
import com.demo.trellolite.Service.MemberService;
import com.demo.trellolite.exceptions.ResourceNotFoundException;
import com.demo.trellolite.securityUtils.MemberUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public MemberDto me() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MemberUserDetails currentMemberUD = (MemberUserDetails) authentication.getPrincipal();
        Long memberId = currentMemberUD.getMember().getId();
        return memberMapper.mapTo(memberRepository.findById(memberId).orElseThrow(
                () -> new ResourceNotFoundException("Member", "id", memberId)
        ));
    }

    @Override
    public List<MemberDto> allMembers() {
        return ((List<Member>) memberRepository.findAll()).stream().map(memberMapper::mapTo).toList();
    }
}
