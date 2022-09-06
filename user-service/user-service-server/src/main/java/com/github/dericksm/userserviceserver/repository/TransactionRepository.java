package com.github.dericksm.userserviceserver.repository;

import com.github.dericksm.userserviceserver.model.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveCrudRepository<Transaction, Integer> {

}
