package com.github.dericksm.orderservicedto.response;

import com.github.dericksm.orderservicedto.OrderStatus;
import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

    private Integer id;
    private String productId;
    private BigDecimal total;
    private OrderStatus status;

}
