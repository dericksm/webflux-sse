package com.github.dericksm.userservicedto.response;

import com.github.dericksm.userservicedto.TransactionStatus;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TransactionResponse {

    private Integer userId;
    private Integer amount;
    private TransactionStatus status;

}