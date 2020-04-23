package com.sbadmin.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sbadmin.api.model.PurchaseProduct;

public interface PurchaseRepository  extends ReactiveMongoRepository<PurchaseProduct, String> {
	    
}
