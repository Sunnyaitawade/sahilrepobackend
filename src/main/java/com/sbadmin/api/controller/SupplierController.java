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

import com.sbadmin.api.model.Supplier;
import com.sbadmin.api.repository.SupplierRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author sunny
 *
 */
@RestController
@RequestMapping("/api/master")
public class SupplierController {
	@Autowired
    private SupplierRepository SupplierRepository;

    @GetMapping("/suppliers")
    public Flux<Supplier> getAllSuppliers() {
        return SupplierRepository.findAll();
    }

    @PostMapping("/suppliers")
    public Mono<Supplier> createSuppliers(@Valid @RequestBody Supplier Supplier) {
        return SupplierRepository.save(Supplier);
    }

    @GetMapping("/suppliers/{id}")
    public Mono<ResponseEntity<Supplier>> getSupplierById(@PathVariable(value = "id") String SupplierId) {
        return SupplierRepository.findById(SupplierId)
                .map(savedSupplier -> ResponseEntity.ok(savedSupplier))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/suppliers/{id}")
    public Mono<ResponseEntity<Supplier>> updateSupplier(@PathVariable(value = "id") String SupplierId,
                                                   @Valid @RequestBody Supplier Supplier) {
        return SupplierRepository.findById(SupplierId)
                .flatMap(existingSupplier -> {
                	existingSupplier.setId(SupplierId);
                	existingSupplier.setName(Supplier.getName());    
                	existingSupplier.setOrganization(Supplier.getOrganization());  
                	existingSupplier.setGstinno(Supplier.getGstinno());
                	existingSupplier.setCity(Supplier.getCity());
                	existingSupplier.setPrevdues(Supplier.getPrevdues());     
                	existingSupplier.setContacts( Supplier.getContacts());     
                	existingSupplier.setFinancelist(Supplier.getFinancelist());   
                    return SupplierRepository.save(existingSupplier);
                })
                .map(updatedSupplier -> new ResponseEntity<>(updatedSupplier, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/suppliers/{id}")
    public Mono<ResponseEntity<Void>> deleteSupplier(@PathVariable(value = "id") String SupplierId) {

        return SupplierRepository.findById(SupplierId)
                .flatMap(existingSupplier ->
                SupplierRepository.delete(existingSupplier)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Suppliers are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/suppliers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Supplier> streamAllSupplier() {
        return SupplierRepository.findAll();
    } 
}
