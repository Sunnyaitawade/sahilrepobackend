/**
 * 
 */
package com.sbadmin.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbadmin.api.model.Customer;
import com.sbadmin.api.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author sunny
 *
 */
@RestController
@RequestMapping("/api/master")
public class CustomerController {
	@Autowired
    private CustomerRepository CustomerRepository;

    @GetMapping("/customers")
    public Flux<Customer> getAllCustomers() {
        return CustomerRepository.findAll();
    }

    @PostMapping("/customers")
    public Mono<Customer> createCustomers(@Valid @RequestBody Customer Customer) {
        return CustomerRepository.save(Customer);
    }

    @GetMapping("/customers/{id}")
    public Mono<ResponseEntity<Customer>> getCustomerById(@PathVariable(value = "id") String CustomerId) {
        return CustomerRepository.findById(CustomerId)
                .map(savedCustomer -> ResponseEntity.ok(savedCustomer))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/customers/{id}")
    public Mono<ResponseEntity<Customer>> updateCustomer(@PathVariable(value = "id") String CustomerId,
                                                   @Valid @RequestBody Customer Customer) {
        return CustomerRepository.findById(CustomerId)
                .flatMap(existingCustomer -> {
                	existingCustomer.setName(Customer.getName());                	 
                    return CustomerRepository.save(existingCustomer);
                })
                .map(updatedCustomer -> new ResponseEntity<>(updatedCustomer, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/customers/{id}")
    public Mono<ResponseEntity<Void>> deleteCustomer(@PathVariable(value = "id") String CustomerId) {

        return CustomerRepository.findById(CustomerId)
                .flatMap(existingCustomer ->
                CustomerRepository.delete(existingCustomer)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Customers are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/customers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> streamAllCustomer() {
        return CustomerRepository.findAll();
    } 
}
