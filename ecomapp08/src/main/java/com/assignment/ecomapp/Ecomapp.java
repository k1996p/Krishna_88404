package com.assignment.ecomapp;

import com.assignment.ecomapp.modal.Product;
import com.assignment.ecomapp.modal.ProductList;

public class Ecomapp {

	public static void main(String[] args) {
		try {
			System.out.println("Display all products");
			Product [] products = ProductList.getProducts();
			printProducts(products);
			
			System.out.println("Update quantity for prouctId");
			
			final int pId=2;
			Product product=findBypId(products, pId);
			if (product!=null) {
				System.out.println("Before update :"+product);
				final int pQuantity=product.getpQuantity()+4;
				product.setpQuantity(pQuantity);
				System.out.println("After update :"+product);
			}
			final String msg=findBypIdAndDelete(products,pId);
			System.out.println(msg);
			
			printProducts(products);
		} catch(Exception e) {
			
		}
	}
	
	private static String findBypIdAndDelete(Product[] products, int pId) {
		for(int i=0;i<products.length;i++) {
			if(products[i].getpId()==pId) {
				products[i]=null;
				return "pId "+pId+" record Deleted ";				
			}
		}
		return "Product not available";
	}
	
	private static Product findBypId(Product[] products, final int pId) {
		for (Product product:products) {
			if(product.getpId()==pId){
				return product;
			}
		}
		return null;
	}

	private static void printProducts(Product[] products) {
		for (Product product : products) {
			System.out.println(product);
		}
	}

}
