package com.shiva.productservice.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.productservice.entity.Product;
import com.shiva.productservice.exception.BadRequestException;
import com.shiva.productservice.exception.ResourceNotFoundException;
import com.shiva.productservice.repository.ProductRepository;
import com.shiva.productservice.service.ProductService;
import com.shiva.productservice.util.DiscountPercentageComparator;
import com.shiva.productservice.util.DiscountPriceComparator;
import com.shiva.productservice.util.ProductAvailabilityComparator;
import com.shiva.productservice.util.ProductIdComparator;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {

		// check if product with product id already exists
		boolean exists = productRepository.existsById(product.getId());
		if (exists == true) {
			throw new BadRequestException("product with id " + product.getId() + " exists");
		}
		// create product and return
		return productRepository.save(product);

	}

	@Override
	public void updateProduct(Integer productId, Product product) {
		Optional<Product> op = productRepository.findById(productId);
		if (op.isPresent()) {
			op.get().setAvailability(product.getAvailability());
			op.get().setRetail_price(product.getRetail_price());
			op.get().setDiscounted_price(product.getDiscounted_price());
		} else
			throw new BadRequestException("Product with id " + productId + " doesnot exists.");

	}

	@Override
	public Product getProductById(Integer productId) {
		Optional<Product> op = productRepository.findById(productId);
		if (op.isPresent())
			return op.get();
		else
			throw new ResourceNotFoundException("Product with id " + productId + " doesnot exists.");
	}

	@Override
	public List<Product> getProducts(String category) {
		List<Product> products = productRepository.findByCategory(category);
		products.sort(new ProductAvailabilityComparator().thenComparing(new DiscountPriceComparator())
				.thenComparing(new ProductIdComparator()));
		return products;
	}

	@Override
	public List<Product> getProducts(String category, boolean availability) {
		List<Product> products = productRepository.findByCategoryAndAvailability(category, availability);
		products.sort(new DiscountPercentageComparator().reversed().thenComparing(new DiscountPriceComparator())
				.thenComparing(new ProductIdComparator()));
		return products;
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

}
