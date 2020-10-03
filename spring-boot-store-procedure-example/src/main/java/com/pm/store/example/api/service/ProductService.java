package com.pm.store.example.api.service;

import java.util.List;

import com.pm.store.example.api.model.Product;

public interface ProductService {

	public List<Product> getProducts();
	
	public List<Product> getProductByProductName(String productName);
}
