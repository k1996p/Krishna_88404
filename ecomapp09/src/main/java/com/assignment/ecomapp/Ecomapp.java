package com.assignment.ecomapp;

import java.util.Set;

import com.assignment.ecomapp.controller.Order;
import com.assignment.ecomapp.controller.OrderTransaction;
import com.assignment.ecomapp.controller.ProductCollection;
import com.assignment.ecomapp.model.Product;
import com.assignment.ecomapp.model.RemoveProduct;

public class Ecomapp {

	public static void main(String[] args) {
		
		Set<Product> itemSet=ProductCollection.getProductset();
		itemSet.add(new RemoveProduct(3,"nike-shoe", 900000.00));
		itemSet.add(new RemoveProduct(0,"puma-shoe", 800000.00));
		itemSet.add(new RemoveProduct(0,"adidas-shoe", 700000.00));
		itemSet.add(new RemoveProduct(0,"campus-shoe", 600000.00));
		
		for(Product item:itemSet) {
			System.out.println(item);
		}
		final Product item1 = ProductCollection.findBypId(1);
		Order qwerty=new OrderTransaction(item1);
		System.out.println("Before transfer");
		System.out.println(item1);
		String msg = "";
		try {
			 msg = qwerty.transfer(3);
		} catch (Exception e) {
			msg = e.getMessage();
		} finally {
			System.out.println(msg);
			System.out.println("After transfer");
			System.out.println(item1);
		}
		
	}

}
