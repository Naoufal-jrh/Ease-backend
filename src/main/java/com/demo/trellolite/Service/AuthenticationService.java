package com.demo.trellolite.Service;

import com.demo.trellolite.Dto.LoginUserDto;
import com.demo.trellolite.Dto.RegisterUserDto;
import com.demo.trellolite.Entity.Member;
import com.demo.trellolite.securityUtils.MemberUserDetails;

public interface AuthenticationService {
     Member authenticate(LoginUserDto user);
     Member register(RegisterUserDto user);
}
