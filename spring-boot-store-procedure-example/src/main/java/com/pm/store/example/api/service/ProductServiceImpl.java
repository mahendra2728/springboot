package com.pm.store.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.store.example.api.dao.ProductDao;
import com.pm.store.example.api.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	@Override
	public List<Product> getProductByProductName(String productName) {
		return productDao.getProductByProductName(productName);
	}

}
