package com.demo.trellolite.Controller;

import com.demo.trellolite.Dto.LoginUserDto;
import com.demo.trellolite.Dto.MemberDto;
import com.demo.trellolite.Dto.RegisterUserDto;
import com.demo.trellolite.Entity.Member;
import com.demo.trellolite.Mapper.Impl.MemberMapper;
import com.demo.trellolite.Service.AuthenticationService;
import com.demo.trellolite.Service.JwtService;
import com.demo.trellolite.securityUtils.MemberUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final MemberMapper memberMapper;

    @PostMapping("/login")
    public String login(@RequestBody LoginUserDto user) {
        Member member = authenticationService.authenticate(user);
        String jwt = jwtService.generateToken(new MemberUserDetails(member));
        return jwt;
    }

    @PostMapping("/register")
    public MemberDto register(@RequestBody RegisterUserDto user) {
        return memberMapper.mapTo(
                authenticationService.register(user)
        );
    }
}
