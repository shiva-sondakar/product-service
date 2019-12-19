package com.shiva.productservice.util;

import java.util.Comparator;

import com.shiva.productservice.entity.Product;

public class ProductIdComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getId().compareTo(o2.getId());
	}

}
