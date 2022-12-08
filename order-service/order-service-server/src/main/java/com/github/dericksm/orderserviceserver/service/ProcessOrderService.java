package com.github.dericksm.orderserviceserver.service;

import com.github.dericksm.orderservicedto.request.CreateOrderRequest;
import com.github.dericksm.orderserviceserver.model.Order;
import reactor.core.publisher.Mono;

public interface ProcessOrderService {

    Mono<Order> processOrder(CreateOrderRequest request);

}
