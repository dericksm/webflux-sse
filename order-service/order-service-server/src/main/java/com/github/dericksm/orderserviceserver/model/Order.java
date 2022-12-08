package com.github.dericksm.orderserviceserver.model;

import com.github.dericksm.orderservicedto.OrderStatus;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Table(name = "orders")
@Entity
@Data
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String productId;
    private Integer userId;
    private BigDecimal total;
    private OrderStatus status;

}
