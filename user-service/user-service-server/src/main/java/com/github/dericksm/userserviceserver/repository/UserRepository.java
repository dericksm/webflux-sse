package com.github.dericksm.userserviceserver.repository;

import java.math.BigDecimal;
import com.github.dericksm.userserviceserver.model.User;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

    @Modifying
    @Query("""
            update user set balance = balance - amount
            where id = : userId and balance >= amount
        """)
    Mono<Boolean> updateBalance(Integer userId, BigDecimal amount);

}
