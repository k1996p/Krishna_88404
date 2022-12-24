package com.assignment.ecomapp.controller;

import com.assignment.ecomapp.model.Product;
import com.assignment.ecomapp.model.RemoveProduct;
import com.assignment.ecomapp.util.CartIsEmpty;

public class OrderTransaction extends Order {

	public OrderTransaction(Product item) {
		super(item);
	}

	@Override
	public boolean remove(Product item, int quantity) throws Exception {
			final int diff=item.getpQuantity()-quantity;
			if(diff>((RemoveProduct) item).CART_EMPTY) {
				item.setpQuantity(diff);
				return true;
			}else {
				throw new CartIsEmpty("order must have some product");
			}
	}
}
