package com.assignment.ecomapp.controller;

import com.assignment.ecomapp.modal.Product;

public class Order {

	private Product cart;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Product cart) {
		super();
		this.cart = cart;
	}
	
	public String buy(Product item, int quantity) {
		item.add(quantity);
		return "yours order is sucsessful with "+item.getpName()+" new quantity is "+item.getpQuantity();
	}
	public String cancel(Product item, int quantity) {
		item.remove(quantity);
		return "yours order is cancelled of "+item.getpName();
	}
	
}
