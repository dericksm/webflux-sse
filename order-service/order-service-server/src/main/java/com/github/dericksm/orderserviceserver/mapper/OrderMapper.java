package com.github.dericksm.orderserviceserver.mapper;

import com.github.dericksm.orderservicedto.request.CreateOrderRequest;
import com.github.dericksm.orderservicedto.response.OrderResponseDTO;
import com.github.dericksm.orderserviceserver.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(CreateOrderRequest createOrderRequest);

    OrderResponseDTO toDTO(Order order);
}
