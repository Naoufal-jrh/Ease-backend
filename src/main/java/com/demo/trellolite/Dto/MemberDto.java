package com.demo.trellolite.Dto;

import lombok.*;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberDto {
    private Long id;

    private String fullName;
    private String email;

    private Date createdAt;
    private Date updatedAt;

    private List<BoardDto> boards;
}
