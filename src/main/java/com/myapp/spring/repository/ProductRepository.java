package com.myapp.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myapp.spring.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
//select * from Products where ProductName=?
	Optional<List<Product>> findByProductNameAllIgnoreCase(String productName);
//select * from products where price>=?
	Optional<List<Product>> findByPriceGreaterThanEqual(Double price);
	
	
}
