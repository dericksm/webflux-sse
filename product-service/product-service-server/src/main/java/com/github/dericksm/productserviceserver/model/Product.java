package com.github.dericksm.productserviceserver.model;

import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Product {

    @Id
    private String id;
    @NotEmpty
    private String description;
    @Positive
    private BigDecimal price;
    @PositiveOrZero
    private Long quantity;
}
