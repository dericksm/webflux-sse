package com.github.dericksm.productserviceserver.mapper;

import com.github.dericksm.productservicedto.request.ProductRequest;
import com.github.dericksm.productservicedto.request.ProductUpdateRequest;
import com.github.dericksm.productservicedto.response.ProductDTO;
import com.github.dericksm.productserviceserver.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);

    Product toProduct(ProductDTO productDTO);

    Product toProduct(ProductRequest productRequest);

    Product toProduct(ProductUpdateRequest productUpdateRequest);

}
