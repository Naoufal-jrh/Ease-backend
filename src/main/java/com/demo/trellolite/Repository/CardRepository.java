package com.demo.trellolite.Repository;

import com.demo.trellolite.Entity.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
