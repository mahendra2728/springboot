package com.pm.store.example.api.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pm.store.example.api.model.Product;

@Repository
public class ProductDao {

	@Autowired
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	public List<Product> getProducts(){
		return entityManager.createNamedStoredProcedureQuery("getProducts").getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<Product> getProductByProductName(String productName) {
		return entityManager.createNamedStoredProcedureQuery("getProductByName").setParameter("pname",productName).getResultList();
	}
	
	public void addProduct(Product product) {
		///entityManager.createNamedStoredProcedureQuery("").
	}
}
