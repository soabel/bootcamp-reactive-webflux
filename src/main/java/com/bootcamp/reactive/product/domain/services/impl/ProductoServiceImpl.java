package com.bootcamp.reactive.product.domain.services.impl;

import com.bootcamp.reactive.product.domain.services.ProductService;
import com.bootcamp.reactive.product.persistence.entitties.Product;
import com.bootcamp.reactive.product.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Flux<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Mono<Product> findById(Integer id) {
        return this.productRepository.findById(id)
                .doOnNext(p -> System.out.println("p = " + p));
    }

    @Override
    public Flux<Product> findBySize(String size) {

        return this.productRepository.findBySize(size);
    }
}
