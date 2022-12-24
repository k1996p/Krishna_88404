package com.assignment.ecomapp;

import com.assignment.ecomapp.modal.Product;

public class Ecomapp {

	public static void main(String[] args) {
			Product product=new Product(0,"nike-shoe", 2.00);
			
			final String msg1=product.add(1);
			final String msg2=product.remove(1);
			
			System.out.println(msg1);
			System.out.println(msg2);
	}

}
