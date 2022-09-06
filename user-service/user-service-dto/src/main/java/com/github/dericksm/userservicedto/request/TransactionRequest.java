package com.github.dericksm.userservicedto.request;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionRequest {

    @NotBlank
    private Integer userId;
    @Positive
    private BigDecimal amount;
}