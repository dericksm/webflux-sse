package com.github.dericksm.orderserviceserver.service;

import com.github.dericksm.orderserviceserver.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {

    Flux<Order> findOrdersByUserId(String userId);
    Mono<Order> create(Order order);

}
