package com.assignment.ecomapp.model;

import com.assignment.ecomapp.util.CartIsEmpty;

public class RemoveProduct extends Product {
	
	public static final int CART_EMPTY=0;

	public RemoveProduct() {
		super();		
	}

	public RemoveProduct(int pId, int pQuantity, String pName, double pPrice) {
		super(pId, pQuantity, pName, pPrice);
	}

	public RemoveProduct(int pQuantity, String pName, double pPrice) {
		super(pQuantity, pName, pPrice);
	}
}
