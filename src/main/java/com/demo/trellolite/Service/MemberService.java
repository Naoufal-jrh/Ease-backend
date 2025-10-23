package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.MemberDto;

import java.util.List;

public interface MemberService {
    MemberDto me();
    List<MemberDto> allMembers();
}
