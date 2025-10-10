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
@ToString(exclude = {"cards", "board"})
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardId") // foreign key instead of join table
    private Board board;

    @OneToMany(mappedBy = "column", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards;
}
