package com.assignment.ecomapp.modal;

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
			this.pQuantity=diff;
			return this.pQuantity+" unit of "+ this.pName+" removed with new quantity "+this.pQuantity+" new price is "+this.pPrice;
		}else {
			throw new Exception("Cart can't be in negation");
		}
		
	}
	
}
