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

import com.sbadmin.api.model.VehicalType;
import com.sbadmin.api.repository.VehicalTypeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author sunny
 *
 */

@RestController
@RequestMapping("/api/master")
public class VehicaltypeController {
	@Autowired
    private VehicalTypeRepository VehicalTypeRepository;

    @GetMapping("/VehicalTypes")
    public Flux<VehicalType> getAllVehicalTypes() {
        return VehicalTypeRepository.findAll();
    }

    @PostMapping("/VehicalTypes")
    public Mono<VehicalType> createVehicalTypes(@Valid @RequestBody VehicalType VehicalType) {
        return VehicalTypeRepository.save(VehicalType);
    }

    @GetMapping("/VehicalTypes/{id}")
    public Mono<ResponseEntity<VehicalType>> getVehicalTypeById(@PathVariable(value = "id") String VehicalTypeId) {
        return VehicalTypeRepository.findById(VehicalTypeId)
                .map(savedVehicalType -> ResponseEntity.ok(savedVehicalType))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/VehicalTypes/{id}")
    public Mono<ResponseEntity<VehicalType>> updateVehicalType(@PathVariable(value = "id") String VehicalTypeId,
                                                   @Valid @RequestBody VehicalType VehicalType) {
        return VehicalTypeRepository.findById(VehicalTypeId)
                .flatMap(existingVehicalType -> {
                	existingVehicalType.setName(VehicalType.getName());                	 
                    return VehicalTypeRepository.save(existingVehicalType);
                })
                .map(updatedVehicalType -> new ResponseEntity<>(updatedVehicalType, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/VehicalTypes/{id}")
    public Mono<ResponseEntity<Void>> deleteVehicalType(@PathVariable(value = "id") String VehicalTypeId) {

        return VehicalTypeRepository.findById(VehicalTypeId)
                .flatMap(existingVehicalType ->
                VehicalTypeRepository.delete(existingVehicalType)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // VehicalTypes are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/VehicalTypes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<VehicalType> streamAllVehicalType() {
        return VehicalTypeRepository.findAll();
    } 
}