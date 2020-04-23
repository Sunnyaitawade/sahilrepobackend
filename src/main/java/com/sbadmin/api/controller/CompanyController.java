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

import com.sbadmin.api.model.Company;
import com.sbadmin.api.repository.CompanyRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author sunny
 *
 */
@RestController
@RequestMapping("/api/master")
public class CompanyController {
	@Autowired
    private CompanyRepository CompanyRepository;

    @GetMapping("/Companys")
    public Flux<Company> getAllCompanys() {
        return CompanyRepository.findAll();
    }

    @PostMapping("/Companys")
    public Mono<Company> createCompanys(@Valid @RequestBody Company Company) {
        return CompanyRepository.save(Company);
    }

    @GetMapping("/Companys/{id}")
    public Mono<ResponseEntity<Company>> getCompanyById(@PathVariable(value = "id") String CompanyId) {
        return CompanyRepository.findById(CompanyId)
                .map(savedCompany -> ResponseEntity.ok(savedCompany))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/Companys/{id}")
    public Mono<ResponseEntity<Company>> updateCompany(@PathVariable(value = "id") String CompanyId,
                                                   @Valid @RequestBody Company Company) {
        return CompanyRepository.findById(CompanyId)
                .flatMap(existingCompany -> {
                	existingCompany.setName(Company.getName());                	 
                    return CompanyRepository.save(existingCompany);
                })
                .map(updatedCompany -> new ResponseEntity<>(updatedCompany, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/Companys/{id}")
    public Mono<ResponseEntity<Void>> deleteCompany(@PathVariable(value = "id") String CompanyId) {

        return CompanyRepository.findById(CompanyId)
                .flatMap(existingCompany ->
                CompanyRepository.delete(existingCompany)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Companys are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/Companys", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Company> streamAllCompany() {
        return CompanyRepository.findAll();
    } 
}
