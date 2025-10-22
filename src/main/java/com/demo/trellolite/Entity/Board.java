package com.demo.trellolite.Entity;

import com.demo.trellolite.Dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.internal.bytebuddy.asm.MemberRemoval;

import javax.sound.midi.MetaMessage;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"columns", "owner"})
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy(value = "position")
    private List<Column> columns;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member owner;

    public Board(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
