/**
 * 
 */
package com.sbadmin.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sbadmin.api.model.Company;
 

/**
 * @author sunny
 *
 */
public interface CompanyRepository extends ReactiveMongoRepository<Company, String>{

}
