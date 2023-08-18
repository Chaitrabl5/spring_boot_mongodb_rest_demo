package com.myapp.spring.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="products")
public class Product {
	@Id
	private String id;
	private Integer productId;
	private String productName;	
	private Double price;	
	private Double starRating;
	private String productCode;
	private String productAvailable;
	private String imageUrl;
	
	
public Product() {
	// TODO Auto-generated constructor stub
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public Integer getProductId() {
	return productId;
}


public void setProductId(Integer productId) {
	this.productId = productId;
}


public String getProductName() {
	return productName;
}


public void setProductName(String productName) {
	this.productName = productName;
}


public Double getPrice() {
	return price;
}


public void setPrice(Double price) {
	this.price = price;
}


public Double getStarRating() {
	return starRating;
}


public void setStarRating(Double starRating) {
	this.starRating = starRating;
}


public String getProductCode() {
	return productCode;
}


public void setProductCode(String productCode) {
	this.productCode = productCode;
}


public String getProductAvailable() {
	return productAvailable;
}


public void setProductAvailable(String productAvailable) {
	this.productAvailable = productAvailable;
}


public String getImageUrl() {
	return imageUrl;
}


public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}


public Product(String id, Integer productId, String productName, Double price, Double starRating, String productCode,
		String productAvailable, String imageUrl) {
	super();
	this.id = id;
	this.productId = productId;
	this.productName = productName;
	this.price = price;
	this.starRating = starRating;
	this.productCode = productCode;
	this.productAvailable = productAvailable;
	this.imageUrl = imageUrl;
}


@Override
public int hashCode() {
	return Objects.hash(id, imageUrl, price, productAvailable, productCode, productId, productName, starRating);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Product other = (Product) obj;
	return Objects.equals(id, other.id) && Objects.equals(imageUrl, other.imageUrl)
			&& Objects.equals(price, other.price) && Objects.equals(productAvailable, other.productAvailable)
			&& Objects.equals(productCode, other.productCode) && Objects.equals(productId, other.productId)
			&& Objects.equals(productName, other.productName) && Objects.equals(starRating, other.starRating);
}


@Override
public String toString() {
	return "Product [id=" + id + ", productId=" + productId + ", productName=" + productName + ", price=" + price
			+ ", starRating=" + starRating + ", productCode=" + productCode + ", productAvailable=" + productAvailable
			+ ", imageUrl=" + imageUrl + "]";
}




}
