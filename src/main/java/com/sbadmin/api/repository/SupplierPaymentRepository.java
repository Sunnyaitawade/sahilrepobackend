package com.sbadmin.api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sbadmin.api.model.SubType;
import com.sbadmin.api.model.SupplierPayment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface SupplierPaymentRepository  extends ReactiveMongoRepository<SupplierPayment, String> {
	@Query("{ 'supplier.id': ?0}")
	Flux < SupplierPayment > findOneByName(final String id);
}
