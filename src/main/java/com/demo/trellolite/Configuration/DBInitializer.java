package com.demo.trellolite.Configuration;

import com.demo.trellolite.Entity.Board;
import com.demo.trellolite.Entity.Card;
import com.demo.trellolite.Entity.Column;
import com.demo.trellolite.Entity.Member;
import com.demo.trellolite.Repository.BoardRepository;
import com.demo.trellolite.Repository.CardRepository;
import com.demo.trellolite.Repository.ColumnRepository;
import com.demo.trellolite.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DBInitializer implements CommandLineRunner {
    private final BoardRepository boardRepository;
    private final ColumnRepository columnRepository;
    private final CardRepository cardRepository;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Member member = Member.builder()
                .fullName("Naoufal Jrhaider")
                .email("Naoufal@gmail.com")
                .passwordHash(passwordEncoder.encode("admin"))
                .build();
        Board board = Board.builder().name("Exams Prep").owner(member).build();

        Column col = Column.builder().name("To Do").board(board).build();

        List<Card> cards = getCards(3);
        for(Card card : cards){
            card.setColumn(col);
        }
        memberRepository.save(member);
        boardRepository.save(board);
        columnRepository.save(col);
        cardRepository.saveAll(cards);
    }

    private List<Card> getCards(int count) {
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < count; i++){
            cards.add(
                    Card.builder().description("Card "+i).build()
            );
        }
        return cards;
    }
}
