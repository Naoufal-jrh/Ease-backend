package com.demo.trellolite.Repository;

import com.demo.trellolite.Entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
