package com.github.dericksm.orderservicedto.response;

import com.github.dericksm.orderservicedto.OrderStatus;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponseDTO {

    private Integer orderId;
    private String productId;
    private BigDecimal amount;
    private OrderStatus status;

}
