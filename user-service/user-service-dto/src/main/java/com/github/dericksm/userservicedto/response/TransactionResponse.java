package com.github.dericksm.userservicedto.response;

import com.github.dericksm.userservicedto.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private Integer userId;
    private Integer amount;
    private TransactionStatus status;

}