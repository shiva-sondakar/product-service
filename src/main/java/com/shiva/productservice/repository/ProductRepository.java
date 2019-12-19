package com.shiva.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(String category);

	List<Product> findByCategoryAndAvailability(String category, boolean availability);

}
