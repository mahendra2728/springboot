package com.pm.store.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pm.store.example.api.model.Product;
import com.pm.store.example.api.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/products/{productName}")
	public ResponseEntity<List<Product>> getProductByProductName(@PathVariable String productName){
		return new ResponseEntity<>(productService.getProductByProductName(productName),HttpStatus.OK);
	}
	
	
	
}
