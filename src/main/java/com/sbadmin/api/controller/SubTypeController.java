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

import com.sbadmin.api.model.SubType;
import com.sbadmin.api.repository.SubTypeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author sunny
 *
 */

@RestController
@RequestMapping("/api/master")
public class SubTypeController {
	@Autowired
    private SubTypeRepository SubTypeRepository;

    @GetMapping("/SubTypes")
    public Flux<SubType> getAllSubTypes() {
        return SubTypeRepository.findAll();
    }

    @PostMapping("/SubTypes")
    public Mono<SubType> createSubTypes(@Valid @RequestBody SubType SubType) {
        return SubTypeRepository.save(SubType);
    }

    @GetMapping("/SubTypes/{id}")
    public Mono<ResponseEntity<SubType>> getSubTypeById(@PathVariable(value = "id") String SubTypeId) {
        return SubTypeRepository.findById(SubTypeId)
                .map(savedSubType -> ResponseEntity.ok(savedSubType))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/SubTypes/{id}")
    public Mono<ResponseEntity<SubType>> updateSubType(@PathVariable(value = "id") String SubTypeId,
                                                   @Valid @RequestBody SubType SubType) {
        return SubTypeRepository.findById(SubTypeId)
                .flatMap(existingSubType -> {
                	existingSubType.setName(SubType.getName());                	 
                    return SubTypeRepository.save(existingSubType);
                })
                .map(updatedSubType -> new ResponseEntity<>(updatedSubType, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/SubTypes/{id}")
    public Mono<ResponseEntity<Void>> deleteSubType(@PathVariable(value = "id") String SubTypeId) {

        return SubTypeRepository.findById(SubTypeId)
                .flatMap(existingSubType ->
                SubTypeRepository.delete(existingSubType)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // SubTypes are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/SubTypes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SubType> streamAllSubType() {
        return SubTypeRepository.findAll();
    } 
}