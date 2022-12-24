package com.assignment.ecomapp.modal;

import com.assignment.ecomapp.util.CartIsEmpty;

public class RemoveProduct extends Product {
	
	public RemoveProduct() {
		super();		
	}

	public RemoveProduct(int pId, int pQuantity, String pName, double pPrice) {
		super(pId, pQuantity, pName, pPrice);
	}

	public RemoveProduct(int pQuantity, String pName, double pPrice) {
		super(pQuantity, pName, pPrice);
	}
	@Override
	public String remove(int quantity) throws Exception {
		final int diff=this.pQuantity- quantity;
		if(diff>0) {
			this.setpQuantity(diff);
		}else {
			throw new CartIsEmpty("Cart can't be empty or in negation");
		}
		return quantity+" unit of "+ this.pName+" removed new quantity "+this.pQuantity+" with new price is "+this.pPrice;

	}
	
}
