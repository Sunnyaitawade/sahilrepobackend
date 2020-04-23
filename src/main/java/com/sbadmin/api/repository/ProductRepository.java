package com.sbadmin.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

 
import com.sbadmin.api.model.Product;

import reactor.core.publisher.Mono;
@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
	   @Query("{ 'name': ?0, 'brand.name': ?1}")
	    Mono<Product> findByNameAndBrand(String name, String brandname);
}
