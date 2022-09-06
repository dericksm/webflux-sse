package com.github.dericksm.userservicedto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionDTO {

    private Integer transactionId;
    private Integer userId;
    private BigDecimal amount;
    private TransactionStatus status;
}
