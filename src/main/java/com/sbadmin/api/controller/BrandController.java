/**
 * 
 */
package com.sbadmin.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbadmin.api.exception.ResourceNotFoundException;
import com.sbadmin.api.model.Brand;
import com.sbadmin.api.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import reactor.core.publisher.Flux;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
/**
 * @author sunny
 *
 */
@RestController
@RequestMapping("/api/master")
public class BrandController {
	@Autowired
    private BrandRepository brandRepository;

    @GetMapping("/brands")
    public Flux<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @PostMapping("/brands")
    public Mono<Brand> createBrands(@Valid @RequestBody Brand brand) {
        return brandRepository.save(brand);
    }

    @GetMapping("/brands/{id}")
    public Mono<ResponseEntity<Brand>> getBrandById(@PathVariable(value = "id") String brandId) {
        return brandRepository.findById(brandId)
                .map(savedBrand -> ResponseEntity.ok(savedBrand))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/brands/{id}")
    public Mono<ResponseEntity<Brand>> updateBrand(@PathVariable(value = "id") String brandId,
                                                   @Valid @RequestBody Brand brand) {
        return brandRepository.findById(brandId)
                .flatMap(existingBrand -> {
                	existingBrand.setName(brand.getName());                	 
                    return brandRepository.save(existingBrand);
                })
                .map(updatedBrand -> new ResponseEntity<>(updatedBrand, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/brands/{id}")
    public Mono<ResponseEntity<Void>> deleteBrand(@PathVariable(value = "id") String brandId) {

        return brandRepository.findById(brandId)
                .flatMap(existingBrand ->
                brandRepository.delete(existingBrand)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Brands are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/brands", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Brand> streamAllBrand() {
        return brandRepository.findAll();
    } 
}
