package com.github.dericksm.productserviceserver.service;

import com.github.dericksm.productserviceserver.service.exception.ResourceNotFoundException;
import com.github.dericksm.productserviceserver.model.Product;
import com.github.dericksm.productserviceserver.repository.ProductRepository;
import com.github.dericksm.productserviceserver.service.interfaces.ProductService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<Product> save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(String id, Product product) {
        return this.getById(id).flatMap(savedProduct -> {
            savedProduct.setPrice(product.getPrice());
            savedProduct.setDescription(product.getDescription());
            return productRepository.save(savedProduct);
        });
    }

    @Override
    public Mono<Product> getById(String id) {
        return productRepository.findById(id).switchIfEmpty(Mono.error(new ResourceNotFoundException(id)));
    }

    @Override
    public Flux<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Void> delete(String id) {
        return this.getById(id).flatMap(product -> productRepository.deleteById(product.getId())).then(Mono.empty());
    }
}
