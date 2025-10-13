package com.demo.trellolite.Dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ColumnDto {
    private Long id;
    private String name;
    private Integer position;

    private List<CardDto> cards;
}
