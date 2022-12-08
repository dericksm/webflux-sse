package com.github.dericksm.orderserviceserver.controller;

import com.github.dericksm.orderservicedto.request.CreateOrderRequest;
import com.github.dericksm.orderservicedto.response.OrderResponseDTO;
import com.github.dericksm.orderserviceserver.mapper.OrderMapper;
import com.github.dericksm.orderserviceserver.service.OrderService;
import com.github.dericksm.orderserviceserver.service.ProcessOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ProcessOrderService processOrderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, ProcessOrderService processOrderService,
        OrderMapper orderMapper) {
        this.orderService = orderService;
        this.processOrderService = processOrderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public Mono<ResponseEntity<OrderResponseDTO>> order(@RequestBody CreateOrderRequest request) {
        return this.processOrderService.processOrder(request).map(orderMapper::toDTO).map(ResponseEntity::ok)
                                       .onErrorReturn(WebClientResponseException.class, ResponseEntity.badRequest().build())
                                       .onErrorReturn(WebClientRequestException.class, ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }

    @GetMapping("/user/{userId}")
    public Flux<OrderResponseDTO> getOrdersByUserId(@PathVariable Integer userId) {
        return this.orderService.findOrdersByUserId(userId).map(orderMapper::toDTO);
    }
}
