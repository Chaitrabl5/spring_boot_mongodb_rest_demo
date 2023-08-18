package com.myapp.spring.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;

@RestController
//spring Managed Bean
//It is capable of handling httprequest and generation http response
//any request from the browser having the url/api/products
@RequestMapping("/api/products")
public class ProductAPI {

	private ProductRepository dao;

	public ProductAPI(ProductRepository dao) {
//		super();
		this.dao = dao;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return new ResponseEntity<List<Product>>(dao.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path="/{productId}")
	public ResponseEntity<Product> findById( @PathVariable("productId") String productId){
		return new ResponseEntity<Product>(dao.findById(productId).
				orElseThrow(()->new NoSuchElementException("np product with"+productId+"Found")),HttpStatus.OK);
	}
	
	@GetMapping(path="/find/{productId}")
	public ResponseEntity<List<Product>> findByProductName( @PathVariable("productName") String productName){
		return new ResponseEntity<List<Product>>(dao.findByProductNameAllIgnoreCase(productName).
				orElseThrow(()->new NoSuchElementException("np product with"+productName+"Found")),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Product> create(@RequestBody Product product ){
		return new ResponseEntity<Product>(dao.save(product),HttpStatus.CREATED);
	}
	
	@PutMapping(path="/{productId}")
	public ResponseEntity<Product> update(@PathVariable("productId") String productId,@RequestBody Product product ){
		Product existingProduct=dao.findById(productId).get();
		BeanUtils.copyProperties(product,existingProduct);
		return new ResponseEntity<Product>(dao.save(product),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{productId}")
	public ResponseEntity<String> delete(@PathVariable("productId") String productId){
		Product existingProduct=dao.findById(productId).get();
		dao.delete(existingProduct);
		return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
	}

	
	
}
