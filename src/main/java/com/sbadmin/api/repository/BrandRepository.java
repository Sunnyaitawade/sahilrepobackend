/**
 * 
 */
package com.sbadmin.api.repository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sbadmin.api.model.Brand;
import com.sbadmin.api.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * @author sunny
 *
 */
@Repository
public interface BrandRepository extends ReactiveMongoRepository<Brand, String> {
	
	@Query("{ 'name': ?0}")
	Mono<Brand> findOneByName(final String name);
}
 
