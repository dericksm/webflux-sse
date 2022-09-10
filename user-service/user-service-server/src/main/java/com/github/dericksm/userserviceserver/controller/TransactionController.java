package com.github.dericksm.userserviceserver.controller;

import com.github.dericksm.userservicedto.request.TransactionRequest;
import com.github.dericksm.userserviceserver.mapper.TransactionMapper;
import com.github.dericksm.userserviceserver.model.Transaction;
import com.github.dericksm.userserviceserver.service.interfaces.TransactionService;
import com.github.dericksm.userserviceserver.service.interfaces.UserService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    public TransactionController(UserService userService, TransactionService transactionService,
        TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
        this.transactionService = transactionService;
    }

    @PostMapping
    public Mono<Transaction> save(@RequestBody @Valid TransactionRequest request){
        return transactionService.save(transactionMapper.toTransaction(request));
    }

}
