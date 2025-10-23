package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.MemberDto;

import java.util.List;

public interface MemberService {
    MemberDto getById(Long id);
    MemberDto me();
    List<MemberDto> allMembers();
}
