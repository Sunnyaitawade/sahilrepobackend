package com.sbadmin.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbadmin.api.model.Supplier;
import com.sbadmin.api.model.SupplierPayment;
 
import com.sbadmin.api.repository.SupplierPaymentRepository;
import com.sbadmin.api.repository.SupplierRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/master")
public class SupplierPaymentController {
	@Autowired
    private SupplierPaymentRepository SupplierPaymentRepository;
	
	@Autowired
    private SupplierRepository SupplierRepository;

    @GetMapping("/SupplierPayments")
    public Flux<SupplierPayment> getAllSupplierPayments() {
        return SupplierPaymentRepository.findAll();
    }
    
    
    
    @PostMapping("/SupplierPayments")
    public Mono<SupplierPayment> createSupplierPayments(@Valid @RequestBody SupplierPayment SupplierPayment) {
    	Supplier supplier = SupplierPayment.getSupplier();
    	int prevdues = 0;
    	prevdues = SupplierPayment.getPrevdues() -SupplierPayment.getPaid_amount() ;
    	 
    	supplier.setPrevdues(prevdues);
    	SupplierRepository.save(supplier).block();
        return SupplierPaymentRepository.save(SupplierPayment);
    }

    @GetMapping("/SupplierPayments/{id}")
    public Flux<SupplierPayment> getSupplierPaymentById(@PathVariable(value = "id") String SupplierPaymentId) {
        return SupplierPaymentRepository.findOneByName(SupplierPaymentId);
                 
    }
}
