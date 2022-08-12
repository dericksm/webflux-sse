package com.github.dericksm.productservicedto.request;

import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequest {

    @NotEmpty
    private String description;
    @Positive
    private BigDecimal price;
    @Positive
    private Long quantity;

}
