package com.github.dericksm.productserviceserver.controller;

import com.github.dericksm.productservicedto.request.ProductRequest;
import com.github.dericksm.productservicedto.request.ProductUpdateRequest;
import com.github.dericksm.productservicedto.response.ProductDTO;
import com.github.dericksm.productserviceserver.mapper.ProductMapper;
import com.github.dericksm.productserviceserver.service.interfaces.ProductService;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
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
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public Mono<ResponseEntity<ProductDTO>> save(@Valid @RequestBody ProductRequest request) {
        return productService.save(productMapper.toProduct(request))
                             .map(productMapper::toProductDTO)
                             .map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ProductDTO>> getById(@PathVariable @NotEmpty String id) {
        return productService.getById(id)
                             .map(productMapper::toProductDTO)
                             .map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<ProductDTO> getAll() {
        return productService.getAll()
                             .map(productMapper::toProductDTO);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<ProductDTO>> update(@PathVariable @NotEmpty String id,
        @RequestBody @Valid ProductUpdateRequest productUpdateRequest) {
        return productService.update(id, productMapper.toProduct(productUpdateRequest))
                             .map(productMapper::toProductDTO)
                             .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable @NotEmpty String id) {
        return productService.delete(id)
                             .map(unused -> ResponseEntity.noContent().build());
    }

}
