package com.github.dericksm.productserviceserver.service.interfaces;


import com.github.dericksm.productserviceserver.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Product> save(Product product);

    Mono<Product> update(String id, Product product);

    Mono<Product> getById(String id);

    Flux<Product> getAll();

    Mono<Void> delete(String id);

}
