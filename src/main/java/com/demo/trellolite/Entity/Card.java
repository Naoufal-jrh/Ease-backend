package com.demo.trellolite.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "columnId") // joint column instead of
    private Column column;
}
