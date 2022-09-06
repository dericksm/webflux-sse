package com.github.dericksm.userserviceserver.mapper;

import com.github.dericksm.userservicedto.TransactionDTO;
import com.github.dericksm.userservicedto.request.TransactionRequest;
import com.github.dericksm.userserviceserver.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionDTO toDTO(Transaction user);
    Transaction toTransaction(TransactionDTO transactionDTO);
    Transaction toTransaction(TransactionRequest transactionRequest);
}
