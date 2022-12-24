package com.assignment.ecomapp;

import com.assignment.ecomapp.controller.Order;
import com.assignment.ecomapp.modal.Product;
import com.assignment.ecomapp.modal.RemoveProduct;

public class Ecomapp {

	public static void main(String[] args) {
			Product product1=new RemoveProduct(0,"nike-shoe", 800000.00);
			Product product2=new RemoveProduct(0,"adidas-shoe", 400000.00);
			
			Order order1=new Order(product1);
			final String msg3=order1.add(product1, 2);
			System.out.println("Before\n"+product1+"\n"+msg3);

			
			Order order2=new Order(product1);
			final String msg4=order2.remove(product1, 1);
			System.out.println("After\n"+product1+"\n"+msg4);

	}

}
