package com.assignment.ecomapp;

import com.assignment.ecomapp.modal.Product;
import com.assignment.ecomapp.modal.RemoveProduct;

public class Ecomapp {

	public static void main(String[] args) {
		Product product1=new RemoveProduct(4,"nike-shoe", 800000.00);
		try {
			final String msg1=product1.remove(3);
			System.out.println(msg1);
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}
	}

}
