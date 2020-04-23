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

import com.sbadmin.api.model.Category;
import com.sbadmin.api.repository.CategoryRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author sunny
 *
 */

@RestController
@RequestMapping("/api/master")
public class CategoryController {
	@Autowired
    private CategoryRepository CategoryRepository;

    @GetMapping("/Categorys")
    public Flux<Category> getAllCategorys() {
        return CategoryRepository.findAll();
    }

    @PostMapping("/Categorys")
    public Mono<Category> createCategorys(@Valid @RequestBody Category Category) {
        return CategoryRepository.save(Category);
    }

    @GetMapping("/Categorys/{id}")
    public Mono<ResponseEntity<Category>> getCategoryById(@PathVariable(value = "id") String CategoryId) {
        return CategoryRepository.findById(CategoryId)
                .map(savedCategory -> ResponseEntity.ok(savedCategory))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/Categorys/{id}")
    public Mono<ResponseEntity<Category>> updateCategory(@PathVariable(value = "id") String CategoryId,
                                                   @Valid @RequestBody Category Category) {
        return CategoryRepository.findById(CategoryId)
                .flatMap(existingCategory -> {
                	existingCategory.setName(Category.getName());                	 
                    return CategoryRepository.save(existingCategory);
                })
                .map(updatedCategory -> new ResponseEntity<>(updatedCategory, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/Categorys/{id}")
    public Mono<ResponseEntity<Void>> deleteCategory(@PathVariable(value = "id") String CategoryId) {

        return CategoryRepository.findById(CategoryId)
                .flatMap(existingCategory ->
                CategoryRepository.delete(existingCategory)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Categorys are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/Categorys", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Category> streamAllCategory() {
        return CategoryRepository.findAll();
    } 
}