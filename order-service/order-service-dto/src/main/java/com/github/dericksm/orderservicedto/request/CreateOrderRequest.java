package com.github.dericksm.orderservicedto.request;

import com.github.dericksm.orderservicedto.OrderLineDTO;
import java.util.Collection;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateOrderRequest {

    @NotNull
    private Integer userId;
    @NotEmpty
    private Collection<OrderLineDTO> products;
}
