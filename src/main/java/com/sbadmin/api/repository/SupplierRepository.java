/**
 * 
 */
package com.sbadmin.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.sbadmin.api.model.Supplier;

/**
 * @author sunny
 *
 */
@Repository
public interface SupplierRepository extends ReactiveMongoRepository<Supplier, String> {

}
 