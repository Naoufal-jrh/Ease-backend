package com.demo.trellolite.Mapper.Impl;

import com.demo.trellolite.Dto.MemberDto;
import com.demo.trellolite.Entity.Member;
import com.demo.trellolite.Mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MemberMapper implements Mapper<Member, MemberDto> {
    private final ModelMapper modelMapper;

    @Override
    public MemberDto mapTo(Member entity) {
        return modelMapper.map(entity, MemberDto.class);
    }

    @Override
    public Member mapFrom(MemberDto dto) {
        return modelMapper.map(dto, Member.class);
    }
}
