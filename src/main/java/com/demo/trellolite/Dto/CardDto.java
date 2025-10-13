package com.demo.trellolite.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CardDto {
    private Long id;
    private String description;
    private Integer position;
}
