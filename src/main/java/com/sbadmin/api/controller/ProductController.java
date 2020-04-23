package com.sbadmin.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

import com.sbadmin.api.model.Brand;
import com.sbadmin.api.model.Category;
import com.sbadmin.api.model.ImportProduct;
import com.sbadmin.api.model.Product;
import com.sbadmin.api.model.SubType;
import com.sbadmin.api.model.VehicalType;
import com.sbadmin.api.repository.BrandRepository;
import com.sbadmin.api.repository.CategoryRepository;
import com.sbadmin.api.repository.ProductRepository;
import com.sbadmin.api.repository.SubTypeRepository;
import com.sbadmin.api.repository.VehicalTypeRepository;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/master")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private SubTypeRepository SubTypeRepository;
	@Autowired
	private CategoryRepository CategoryRepository;
	@Autowired
	private VehicalTypeRepository VehicalTypeRepository;

	@GetMapping("/products")
	public Flux<Product> getAllproducts() {
		return productRepository.findAll();
	}

	@PostMapping("/products")
	public Mono<Product> createproducts(@Valid @RequestBody Product Product) {
		return productRepository.save(Product);
	}

	@GetMapping("/products/{id}")
	public Mono<ResponseEntity<Product>> getProductById(@PathVariable(value = "id") String ProductId) {
		return productRepository.findById(ProductId).map(savedProduct -> ResponseEntity.ok(savedProduct))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PutMapping("/products/{id}")
	public Mono<ResponseEntity<Product>> updateProduct(@PathVariable(value = "id") String ProductId,
			@Valid @RequestBody Product Product) {
		return productRepository.findById(ProductId).flatMap(existingProduct -> {
			existingProduct.setName(Product.getName());
			return productRepository.save(existingProduct);
		}).map(updatedProduct -> new ResponseEntity<>(updatedProduct, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/products/{id}")
	public Mono<ResponseEntity<Void>> deleteProduct(@PathVariable(value = "id") String ProductId) {

		return productRepository.findById(ProductId)
				.flatMap(existingProduct -> productRepository.delete(existingProduct)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/products/imports")
	public void importproducts(@RequestBody List<ImportProduct> products) {

		// System.out.println(products.toString());
		for (ImportProduct singleproduct : products) {
			//brand
			String brandname = singleproduct.getBrand();
			Brand dbBrand = brandRepository.findOneByName(brandname).block();
			if (dbBrand == null) {
				Brand brand = new Brand();
				brand.setName(singleproduct.getBrand());
				dbBrand = brandRepository.save(brand).block();
			}
			
			//sub type
			String subtypename = singleproduct.getSubtype();
			SubType dbsubtyp = SubTypeRepository.findOneByName(subtypename).block();
			if (dbsubtyp == null) {
				SubType subtype = new SubType();
				subtype.setName(subtypename);
				dbsubtyp = SubTypeRepository.save(subtype).block();
			}
			
			//vehical type
			String vehicaltypename = singleproduct.getVehicletype();
			VehicalType dbvehicaltyp = VehicalTypeRepository.findOneByName(vehicaltypename).block();
			if (dbvehicaltyp == null) {
				VehicalType vehicaltype = new VehicalType();
				vehicaltype.setName(vehicaltypename);
				dbvehicaltyp = VehicalTypeRepository.save(vehicaltype).block();
			}
         
			//category
			String categoryname = singleproduct.getCategory();
			Category dbCategory = CategoryRepository.findOneByName(categoryname).block();
			if (dbCategory == null) {
				Category category = new Category();
				category.setName(categoryname);
				dbCategory = CategoryRepository.save(category).block();
			}
           
			//product 
			String productname = singleproduct.getSize();
			Product Dbproduct = productRepository.findByNameAndBrand(productname, brandname).block();
			if (Dbproduct == null) {
				Product newproduct = new Product();
				newproduct.setName(productname);
				newproduct.setBrand(dbBrand);
				newproduct.setCategory(dbCategory);
				newproduct.setSubtype(dbsubtyp);
				newproduct.setVehicaltype(dbvehicaltyp);
				newproduct.setCgst(singleproduct.getCsgst());
				newproduct.setSgst(singleproduct.getSgst());
				Dbproduct = productRepository.save(newproduct).block();
			}
		}

	}

	// products are Sent to the client as Server Sent Events
	@GetMapping(value = "/stream/products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Product> streamAllProduct() {
		return productRepository.findAll();
	}
}
