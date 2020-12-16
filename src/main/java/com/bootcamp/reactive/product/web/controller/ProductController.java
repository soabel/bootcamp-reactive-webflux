package com.bootcamp.reactive.product.web.controller;

import com.bootcamp.reactive.product.domain.services.ProductService;
import com.bootcamp.reactive.product.persistence.entitties.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    Flux<Product> findAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    Mono<Product> findById(@PathVariable("id") Integer id) {
        return this.productService.findById(id);
    }

    @GetMapping("/by-size/{size}")
    Flux<Product> findBySize(@PathVariable("size") String size) {
        return this.productService.findBySize(size);
    }


}
