/**
 * 
 */
package com.sbadmin.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sbadmin.api.model.Category;
import com.sbadmin.api.model.SubType;

import reactor.core.publisher.Mono;

/**
 * @author sunny
 *
 */
@Repository
public interface SubTypeRepository  extends ReactiveMongoRepository<SubType, String> {
	@Query("{ 'name': ?0}")
	Mono < SubType > findOneByName(final String name);
}