package com.shiva.productservice.util;

import java.util.Comparator;

import com.shiva.productservice.entity.Product;

public class DiscountPriceComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		if(o1.getDiscounted_price() == null)
			return -1;
		if(o2.getDiscounted_price() == null) {
			return 1;
		}
		
		return o1.getDiscounted_price().compareTo(o2.getDiscounted_price());
	}

}
