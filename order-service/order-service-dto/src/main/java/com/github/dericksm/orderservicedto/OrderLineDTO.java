package com.github.dericksm.orderservicedto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderLineDTO {

    private Integer productId;
    private Integer quantity;

}
