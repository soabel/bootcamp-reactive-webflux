package com.bootcamp.reactive.product.persistence.repositories;

import com.bootcamp.reactive.product.persistence.entitties.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends R2dbcRepository<Product, Integer> {
    @Query("SELECT * FROM Producto WHERE size=@size")
    Flux<Product> findBySize(String size);
}
