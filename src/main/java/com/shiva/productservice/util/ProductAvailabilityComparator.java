package com.shiva.productservice.util;

import java.util.Comparator;

import com.shiva.productservice.entity.Product;

public class ProductAvailabilityComparator implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		if(o1.getAvailability() == null) {
			return -1;
		}
		if(o2.getAvailability() == null) {
			return 1;
		}
		
		return o1.getAvailability().compareTo(o2.getAvailability());
	}

}
