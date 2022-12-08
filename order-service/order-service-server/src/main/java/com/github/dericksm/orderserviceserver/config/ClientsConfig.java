package com.github.dericksm.orderserviceserver.config;

import com.github.dericksm.productserviceclient.ProductServiceClient;
import com.github.dericksm.userserviceclient.UserServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientsConfig {

    @Bean
    public ProductServiceClient productServiceClient(){
        return new ProductServiceClient("http://localhost:8080/products/");
    }

    @Bean
    public UserServiceClient userServiceClient(){
        return new UserServiceClient("http://localhost:8081/");
    }

}
