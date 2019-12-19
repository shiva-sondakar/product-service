package com.shiva.productservice.util;

import java.util.Comparator;

import com.shiva.productservice.entity.Product;

public class DiscountPercentageComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		if (o1.getRetail_price() == null || o1.getDiscounted_price() == null)
			return -1;
		if (o2.getRetail_price() == null || o1.getDiscounted_price() == null) {
			return 1;
		}
		int a = (int) ((o1.getRetail_price().floatValue() - o1.getDiscounted_price().floatValue())
				/ o1.getRetail_price().floatValue()) * 100;
		int b = (int) ((o2.getRetail_price().floatValue() - o2.getDiscounted_price().floatValue())
				/ o2.getRetail_price().floatValue()) * 100;
		return a - b;
	}

}
