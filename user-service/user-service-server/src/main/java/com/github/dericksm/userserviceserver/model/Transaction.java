package com.github.dericksm.userserviceserver.model;

import com.github.dericksm.userservicedto.TransactionStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("transactions")
public class Transaction {

    @Id
    private Integer id;
    private Integer userId;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private TransactionStatus status;

}
