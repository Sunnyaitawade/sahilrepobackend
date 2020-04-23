/**
 * 
 */
package com.sbadmin.api.controller;

 

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbadmin.api.model.Product;
import com.sbadmin.api.model.ProductDetails;
import com.sbadmin.api.model.PurchaseProduct;
import com.sbadmin.api.model.Supplier;
import com.sbadmin.api.repository.ProductRepository;
import com.sbadmin.api.repository.PurchaseRepository;
import com.sbadmin.api.repository.SupplierRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author sunny
 *
 */
@RestController
@RequestMapping("/api/master")
public class PurchaseController {
	@Autowired
    private PurchaseRepository purchaseRepository;

	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
    private SupplierRepository SupplierRepository;

    @PostMapping("/Purchases")
    public Mono<PurchaseProduct> createPurchases(@RequestBody PurchaseProduct purchaseProduct) {
    	ProductDetails purchaseItmes[] = purchaseProduct.getPurchaseitmes();   	 
    	Supplier supplier = purchaseProduct.getSupplier(); 
    	 for (ProductDetails productDetails : purchaseItmes) {      	   
    		        Product existingDbProduct =productDetails.getProduct();    		        
    				existingDbProduct.setQty(productDetails.getQty()+productDetails.getProduct().getQty());
    				existingDbProduct.setPrice_per_unit(productDetails.getPrice_per_unit()); 
    				existingDbProduct.setTotal_gst(productDetails.getTotal_gst());
    				existingDbProduct.setTotal_gst(productDetails.getTotal_gst());
    				existingDbProduct.setCost_pr_unit(productDetails.getCost_pr_unit());
    				existingDbProduct.setSale_price(productDetails.getSale_price());
    				System.out.println("To be saved:"+existingDbProduct.toString());
    				productRepository.save(existingDbProduct).block();    					 
		}
    	 System.out.println(supplier.getPrevdues());
    	 System.out.println(purchaseProduct.getDues());
    	 int prevdues = supplier.getPrevdues()+ purchaseProduct.getDues();
    	 System.out.println(prevdues);
    	 supplier.setPrevdues(prevdues);
    	 SupplierRepository.save(supplier).block();
        return purchaseRepository.save(purchaseProduct);
    }
     
    @GetMapping("/Purchases")
    public Flux<PurchaseProduct> getAllPurchases() {
        return purchaseRepository.findAll();
    }
    
    @DeleteMapping("/Purchases/{id}")
    public Mono<ResponseEntity<Void>> deletePurchases(@PathVariable(value = "id") String purchaseId) {

        return purchaseRepository.findById(purchaseId)
                .flatMap(existingPurchase ->
                purchaseRepository.delete(existingPurchase)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
