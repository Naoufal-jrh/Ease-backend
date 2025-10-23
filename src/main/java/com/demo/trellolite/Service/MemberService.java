package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.MemberDto;
import com.demo.trellolite.Entity.Member;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.List;

public interface MemberService {
    MemberDto me();
    List<MemberDto> allMembers();
}
