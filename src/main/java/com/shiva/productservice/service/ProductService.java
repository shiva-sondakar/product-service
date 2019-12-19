package com.shiva.productservice.service;

import java.util.List;

import com.shiva.productservice.entity.Product;

public interface ProductService {

	Product addProduct(Product product);

	void updateProduct(Integer productId, Product product);

	Product getProductById(Integer productId);

	List<Product> getProducts(String category);

	List<Product> getProducts(String category, boolean availability);

	List<Product> getProducts();

}
