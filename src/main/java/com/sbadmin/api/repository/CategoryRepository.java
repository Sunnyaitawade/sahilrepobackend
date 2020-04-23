/**
 * 
 */
package com.sbadmin.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sbadmin.api.model.Brand;
import com.sbadmin.api.model.Category;

import reactor.core.publisher.Mono;

/**
 * @author sunny
 *
 */
@Repository
public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
	@Query("{ 'name': ?0}")
	Mono < Category > findOneByName(final String name);
}
 
