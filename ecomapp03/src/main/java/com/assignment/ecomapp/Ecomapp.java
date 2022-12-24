package com.assignment.ecomapp;

import com.assignment.ecomapp.controller.Order;
import com.assignment.ecomapp.modal.Product;

public class Ecomapp {

	public static void main(String[] args) {
			Product product1=new Product(0,"nike-shoe", 800000.00);
			Product product2=new Product(0,"adidas-shoe", 400000.00);
			 
			Order order1=new Order(product1);
			final String msg3=order1.buy(product1, 1);
			
			Order order2=new Order(product1);
			final String msg4=order2.cancel(product1, 2);
			
			System.out.println(msg3);
			System.out.println(msg4);
			
	}

}
