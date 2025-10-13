package com.demo.trellolite.Repository;

import com.demo.trellolite.Entity.Column;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ColumnRepository extends CrudRepository<Column, Long> {
    List<Column> findByBoardId(Long boardId);
}
