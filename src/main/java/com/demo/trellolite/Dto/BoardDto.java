package com.demo.trellolite.Dto;

import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardDto {
    private Long id;
    private String name;
    private List<ColumnDto> columns;
}
