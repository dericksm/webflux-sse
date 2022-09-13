package com.github.dericksm.orderserviceserver.repository;

import com.github.dericksm.orderserviceserver.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findOrdersByUserId(String userId);

}
