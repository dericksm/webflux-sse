package com.github.dericksm.userserviceserver.service.interfaces;

import com.github.dericksm.userserviceserver.model.Transaction;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<Transaction> save(Transaction transaction);
}
