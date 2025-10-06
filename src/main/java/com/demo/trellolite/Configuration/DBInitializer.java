package com.demo.trellolite.Configuration;

import com.demo.trellolite.Entity.Board;
import com.demo.trellolite.Entity.Card;
import com.demo.trellolite.Entity.Column;
import com.demo.trellolite.Repository.BoardRepository;
import com.demo.trellolite.Repository.CardRepository;
import com.demo.trellolite.Repository.ColumnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DBInitializer implements CommandLineRunner {
    private final BoardRepository boardRepository;
    private final ColumnRepository columnRepository;
    private final CardRepository cardRepository;

    @Override
    public void run(String... args) throws Exception {
        Column col1 = Column.builder()
                .title("Column 1")
                .cards(getCards(3))
                .build();
        Column col2 = Column.builder()
                .title("Column 2")
                .cards(getCards(5))
                .build();
        List<Column> columns = (List<Column>) columnRepository.saveAll(List.of(col1, col2));
        Board board = Board.builder()
                .columns(columns)
                .build();
        boardRepository.save(board);
    }

    private List<Card> getCards(int count) {
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < count; i++){
            cards.add(
                    Card.builder().description("Card "+i).build()
            );
        }
        return (List<Card>) cardRepository.saveAll(cards);
    }
}
