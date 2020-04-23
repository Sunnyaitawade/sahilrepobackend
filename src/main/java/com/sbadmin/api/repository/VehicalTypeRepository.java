package com.sbadmin.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sbadmin.api.model.SubType;
import com.sbadmin.api.model.VehicalType;

import reactor.core.publisher.Mono;

@Repository
public interface VehicalTypeRepository extends ReactiveMongoRepository<VehicalType, String> {
	@Query("{ 'name': ?0}")
	Mono < VehicalType > findOneByName(final String name);
}
 