/**
 * 
 */
package com.sbadmin.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

 
import com.sbadmin.api.model.Customer;

/**
 * @author sunny
 *
 */
@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

}
 
