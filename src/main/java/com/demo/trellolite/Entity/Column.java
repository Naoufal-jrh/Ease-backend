package com.demo.trellolite.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.internal.bytebuddy.utility.nullability.MaybeNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    private List<Card> cards;
}
