package com.github.dericksm.userserviceclient;

import com.github.dericksm.userservicedto.TransactionDTO;
import com.github.dericksm.userservicedto.UserDTO;
import com.github.dericksm.userservicedto.request.TransactionRequest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserServiceClient {

    private WebClient webClient;

    public UserServiceClient(String url) {
        this.webClient = WebClient.builder()
                                  .baseUrl(url)
                                  .build();
    }


    public Mono<TransactionDTO> createTransaction(TransactionRequest request) {
        return this.webClient
            .post()
            .uri("transactions")
            .bodyValue(request)
            .retrieve()
            .bodyToMono(TransactionDTO.class);
    }

    public Flux<UserDTO> getAllUsers() {
        return this.webClient
            .get()
            .uri("users")
            .retrieve()
            .bodyToFlux(UserDTO.class);
    }
}
