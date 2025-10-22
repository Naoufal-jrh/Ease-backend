package com.demo.trellolite.Service.Impl;

import com.demo.trellolite.Dto.LoginUserDto;
import com.demo.trellolite.Dto.RegisterUserDto;
import com.demo.trellolite.Entity.Member;
import com.demo.trellolite.Repository.MemberRepository;
import com.demo.trellolite.Service.AuthenticationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final MemberRepository memberRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Member authenticate(LoginUserDto user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );
        return memberRepository.findByEmail(user.getEmail()).orElseThrow();
    }

    @Override
    public Member register(RegisterUserDto user) {
        String passwordHash = passwordEncoder.encode(user.getPassword());
        Member member = Member.builder()
                .email(user.getEmail())
                .fullName(user.getFullName())
                .passwordHash(passwordHash)
                .build();

        return memberRepository.save(member);
    }
}
