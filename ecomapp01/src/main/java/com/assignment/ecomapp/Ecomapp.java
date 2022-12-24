package com.assignment.ecomapp;

import com.assignment.ecomapp.modal.Product;

public class Ecomapp {

	public static void main(String[] args) {
		
			Product product1=new Product("nike-shoe", 800000.00);
			Product product2=new Product("adidas-shoe", 500000.00);
			
			System.out.println(product1);
			System.out.println(product2);
	}

}
