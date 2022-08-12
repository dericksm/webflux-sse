package com.github.dericksm.productservicedto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {

    private String id;
    private String description;
    private BigDecimal price;
    private Long quantity;

}