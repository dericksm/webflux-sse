package com.github.dericksm.userserviceserver.service;

import com.github.dericksm.userservicedto.TransactionStatus;
import com.github.dericksm.userserviceserver.repository.TransactionRepository;
import com.github.dericksm.userserviceserver.service.interfaces.UserService;
import com.github.dericksm.userserviceserver.model.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import com.github.dericksm.userserviceserver.service.interfaces.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;

    public TransactionServiceImpl(TransactionRepository transactionRepository, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    @Transactional
    @Override
    public Mono<Transaction> save(Transaction transaction) {
        return userService.updateBalance(transaction.getUserId(), transaction.getAmount())
                          .filter(Boolean::booleanValue)
                          .flatMap(b -> {
                              transaction.setStatus(TransactionStatus.APPROVED);
                              return transactionRepository.save(transaction);
                          });
    }
}
