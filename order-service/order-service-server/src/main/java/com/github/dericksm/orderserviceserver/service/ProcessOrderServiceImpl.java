package com.github.dericksm.orderserviceserver.service;

import com.github.dericksm.orderservicedto.OrderStatus;
import com.github.dericksm.orderservicedto.request.CreateOrderRequest;
import com.github.dericksm.orderserviceserver.model.Order;
import com.github.dericksm.productserviceclient.ProductServiceClient;
import com.github.dericksm.userserviceclient.UserServiceClient;
import com.github.dericksm.userservicedto.TransactionStatus;
import com.github.dericksm.userservicedto.request.TransactionRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProcessOrderServiceImpl implements ProcessOrderService {

    private final ProductServiceClient productServiceClient;
    private final UserServiceClient userServiceClient;
    private final OrderService orderService;

    public ProcessOrderServiceImpl(ProductServiceClient productServiceClient,
        UserServiceClient userServiceClient, OrderService orderService) {
        this.productServiceClient = productServiceClient;
        this.userServiceClient = userServiceClient;
        this.orderService = orderService;
    }

    @Override
    public Mono<Order> processOrder(CreateOrderRequest request) {
        return productServiceClient.getProductById(request.getProductId())
            .flatMap(productDTO -> {
                var transactionRequest = new TransactionRequest();
                transactionRequest.setUserId(request.getUserId());
                transactionRequest.setAmount(productDTO.getPrice());
               return userServiceClient.createTransaction(transactionRequest);
            })
           .flatMap(transactionDTO -> {
               var order = new Order();
                order.setUserId(request.getUserId());
                order.setProductId(request.getProductId());
                order.setTotal(transactionDTO.getAmount());
                order.setStatus(TransactionStatus.APPROVED.equals(transactionDTO.getStatus()) ? OrderStatus.COMPLETED : OrderStatus.FAILED);
                return orderService.create(order);
           });
    }
}
