package com.github.dericksm.userserviceserver.service;

import java.math.BigDecimal;
import com.github.dericksm.userserviceserver.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.github.dericksm.userserviceserver.repository.UserRepository;
import com.github.dericksm.userserviceserver.service.exception.ResourceNotFoundException;
import com.github.dericksm.userserviceserver.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> update(Integer id, User user) {
        return getById(id)
            .flatMap(savedUser -> {
            savedUser.setName(user.getName());
            return userRepository.save(savedUser);
        });
    }

    @Override
    public Mono<User> getById(Integer id) {
        return userRepository.findById(id).switchIfEmpty(Mono.error(new ResourceNotFoundException(id)));
    }

    @Override
    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return getById(id)
            .doOnSuccess(user -> userRepository.delete(user).subscribe())
            .flatMap(user -> Mono.empty());
    }

    @Override
    public Mono<Boolean> updateBalance(Integer id, BigDecimal chargeAmount){
        return getById(id)
            .doOnSuccess(user -> userRepository.updateBalance(id, chargeAmount).subscribe())
            .flatMap(user -> Mono.just(Boolean.TRUE))
            .defaultIfEmpty(Boolean.FALSE);
    }

}
