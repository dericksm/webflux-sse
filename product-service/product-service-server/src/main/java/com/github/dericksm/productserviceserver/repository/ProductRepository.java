package com.github.dericksm.productserviceserver.repository;

import com.github.dericksm.productserviceserver.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
