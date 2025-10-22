package com.demo.trellolite.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUserDto {
    private String email;
    private String fullName;
    private String password;
}
