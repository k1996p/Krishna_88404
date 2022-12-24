package com.assignment.ecomapp.controller;

import java.util.HashSet;
import java.util.Set;

import com.assignment.ecomapp.model.Product;

public class ProductCollection {
	
	private static final Set<Product> itemSet=new HashSet<>();

	private ProductCollection() {
		super();
	}
	public static Set<Product> getProductset() {
		return itemSet;
	}
	public static String addNewProduct(Product item) {
		if(itemSet.add(item)) {
			return "Added new Product "+item;
		}else {
			return "Error while adding product "+item;

		}
	}
	public static String UpdatepQuantityBypId(int pId, int pQuantity) {
		Product item=findBypId(pId);
		item.setpId(pId);
		return "Error while Updating the details";
	}
	public static Product findBypId(int pId) {
		for(Product item: itemSet) {
			if(item.getpId()==pId) {
				return item;
			}
		}
		return null;
	}
	
}
