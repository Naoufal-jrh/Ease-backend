package com.demo.trellolite.Repository;

import com.demo.trellolite.Entity.Board;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {

    @Query("select new Board(b.id, b.name) from Board b")
    List<Board> findAllBoards();
}
