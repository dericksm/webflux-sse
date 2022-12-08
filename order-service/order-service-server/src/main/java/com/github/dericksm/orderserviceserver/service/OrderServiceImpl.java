package com.github.dericksm.orderserviceserver.service;

import com.github.dericksm.orderserviceserver.model.Order;
import com.github.dericksm.orderserviceserver.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Flux<Order> findOrdersByUserId(Integer userId) {
        return Flux.fromStream(() -> orderRepository.findOrdersByUserId(userId).stream())
                   .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<Order> create(Order order) {
        return Mono.just(orderRepository.save(order)).subscribeOn(Schedulers.boundedElastic());
    }
}
