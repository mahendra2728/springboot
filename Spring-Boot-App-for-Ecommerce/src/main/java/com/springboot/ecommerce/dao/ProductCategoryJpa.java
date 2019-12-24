package com.springboot.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springboot.ecommerce.entity.ProductCategory;

@Repository
@CrossOrigin("http://localhost:4200")
public interface ProductCategoryJpa extends JpaRepository<ProductCategory, Long> {

}
