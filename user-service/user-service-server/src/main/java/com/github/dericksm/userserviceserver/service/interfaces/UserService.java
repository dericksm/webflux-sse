package com.github.dericksm.userserviceserver.service.interfaces;

import java.math.BigDecimal;
import com.github.dericksm.userserviceserver.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> save(User product);

    Mono<User> update(Integer id, User product);

    Mono<User> getById(Integer id);

    Flux<User> getAll();

    Mono<Void> delete(Integer id);

    Mono<Boolean> updateBalance(Integer id, BigDecimal chargeAmount);
}
