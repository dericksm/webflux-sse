package com.github.dericksm.userserviceserver.controller;

import com.github.dericksm.userservicedto.UserDTO;
import com.github.dericksm.userservicedto.request.UserRequest;
import com.github.dericksm.userserviceserver.service.interfaces.UserService;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import com.github.dericksm.userserviceserver.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public Mono<ResponseEntity<UserDTO>> save(@Valid @RequestBody UserRequest request) {
        return userService.save(userMapper.toUser(request))
                          .map(userMapper::toDTO)
                          .map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserDTO>> getById(@PathVariable @NotEmpty Integer id) {
        return userService.getById(id)
                          .map(userMapper::toDTO)
                          .map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<UserDTO> getAll() {
        return userService.getAll()
                          .map(userMapper::toDTO);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<UserDTO>> update(@PathVariable Integer id,
        @RequestBody UserRequest request) {
        return userService.update(id, userMapper.toUser(request))
                          .map(userMapper::toDTO)
                          .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable @NotEmpty Integer id) {
        return userService.delete(id)
                          .map(unused -> ResponseEntity.noContent().build());
    }
}
