package com.shiva.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shiva.productservice.entity.Product;
import com.shiva.productservice.service.ProductService;

@RestControllerAdvice
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product p = productService.addProduct(product);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{product_id}")
	public ResponseEntity<Void> updateProduct(@PathVariable("product_id") Integer productId,
			@RequestBody Product product) {
		productService.updateProduct(productId, product);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/{product_id}")
	public ResponseEntity<Product> getById(@PathVariable("product_id") Integer productId) {
		return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Product>> getProductsByCategoryAndAvailability(
			@RequestParam(required = false) String category, @RequestParam(required = false) Boolean availability) {
		if (!StringUtils.isEmpty(category) && !StringUtils.isEmpty(availability)) {
			return new ResponseEntity<List<Product>>(productService.getProducts(category, availability), HttpStatus.OK);
		} else if (!StringUtils.isEmpty(category) && StringUtils.isEmpty(availability)) {
			return new ResponseEntity<List<Product>>(productService.getProducts(category), HttpStatus.OK);
		}
		return new ResponseEntity<List<Product>>(productService.getProducts(), HttpStatus.OK);
	}

}
