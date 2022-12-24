package com.assignment.ecomapp.modal;

public class ProductList {
	
	private static final Product [] PRODUCTS=new Product[10];
	
	static {
		PRODUCTS[0]= new RemoveProduct(0,"nike-shoe", 900000.00);
		PRODUCTS[1]= new RemoveProduct(0,"puma-shoe", 800000.00);
		PRODUCTS[2]= new RemoveProduct(0,"adidas-shoe", 700000.00);
		PRODUCTS[3]= new RemoveProduct(0,"air-shoe", 600000.00);
		PRODUCTS[4]= new RemoveProduct(0,"campus-shoe", 500000.00);
		PRODUCTS[5]= new RemoveProduct(0,"bata-shoe", 400000.00);
		PRODUCTS[6]= new RemoveProduct(0,"wrong-shoe", 300000.00);
		PRODUCTS[7]= new RemoveProduct(0,"nice-shoe", 200000.00);
		PRODUCTS[8]= new RemoveProduct(0,"good-shoe", 100000.00);
		PRODUCTS[9]= new RemoveProduct(0,"bad-shoe", 800000.00);
	}
	
	public ProductList() {
		super();
	}

	public static Product[] getProducts() {
		return PRODUCTS;
	}

}
