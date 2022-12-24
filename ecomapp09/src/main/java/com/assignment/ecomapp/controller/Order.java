package com.assignment.ecomapp.controller;

import com.assignment.ecomapp.model.Product;

public abstract class Order {
	
		private Product item;
		
		public Order(Product item) {
			this.item=item;
		}
		
		public String transfer(int quantity) throws Exception {
			if(add(item, quantity)) {
				if(remove(item,quantity)) {
					return item.getpName()+" added "+item.getpQuantity()+" & removed "+item.getpQuantity();
				}
			}
			return "Please add product";
		}
		
		public abstract boolean remove(Product item, int quantity) throws Exception; 
		
		public boolean add(Product item, int quantity){
			int quantity1=item.getpQuantity()+ quantity;
			item.setpQuantity(quantity1);
			return true;
		}
}
