package com.bootcamp.reactive.product.domain.services;

import com.bootcamp.reactive.product.persistence.entitties.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> findAll();
    Mono<Product> findById(Integer id);
    Flux<Product> findBySize(String size);
}
