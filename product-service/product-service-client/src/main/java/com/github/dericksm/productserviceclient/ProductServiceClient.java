package com.github.dericksm.productserviceclient;

import com.github.dericksm.productservicedto.response.ProductDTO;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductServiceClient {

    private WebClient webClient;

    public ProductServiceClient(String url) {
        this.webClient = WebClient.builder()
                                  .baseUrl(url)
                                  .build();
    }

    public Mono<ProductDTO> getProductById(final String productId) {
        return this.webClient
            .get()
            .uri("{id}", productId)
            .retrieve()
            .bodyToMono(ProductDTO.class);
    }

    public Flux<ProductDTO> getAllProducts() {
        return this.webClient
            .get()
            .uri("all")
            .retrieve()
            .bodyToFlux(ProductDTO.class);
    }
}
