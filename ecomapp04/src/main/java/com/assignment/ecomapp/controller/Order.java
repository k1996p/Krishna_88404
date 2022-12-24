package com.assignment.ecomapp.controller;

import com.assignment.ecomapp.modal.Product;

public class Order {

	private Product item;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Product cart) {
		super();
		this.item = item;
	}
	
	public String add(Product item, int quantity) {
		item.add(quantity);
		return "yours cart is added with "+item.getpName()+" new quantity is "+item.getpQuantity();
	}
	public String remove(Product item, int quantity) {
		try {
			String msg1 = item.remove(quantity);
			return msg1;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
}
