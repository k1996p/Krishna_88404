package com.assignment.ecomapp;

import java.sql.SQLException;
import java.util.List;

import com.assignment.ecomapp.controller.ProductController;
import com.assignment.ecomapp.dao.DbConnection;
import com.assignment.ecomapp.dao.ProductDao;
import com.assignment.ecomapp.modal.Product;

public class Ecomapp {

	public static void main(String[] args) {
		try {
			final ProductController productController=
					ProductController.getProductController();
			System.out.println("1. Displa all Produst");
			System.out.println("2. product Details by pId");
			System.out.println("3. Delete product by pId");
			System.out.println("4. Update quantity by pId");
			
			int choice=1;
			System.out.println("1. Display all Products");
			mainOptions(productController, choice);
			
			System.out.println("2. product Details by pId");
			choice=2;
			mainOptions(productController, choice);
			
			System.out.println("3. Delete product by pId");
			choice=3;
			mainOptions(productController, choice);
			
			System.out.println("4. Update Quantity by pId");
			choice=4;
			mainOptions(productController, choice);
			choice=1;
			System.out.println("1. Display all Accoutns");
			mainOptions(productController, choice);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void mainOptions(final ProductController productController, int choice) throws SQLException {
		switch(choice) {
		case 1: 
				List<Product> list=productController.findAll();
				for(Product product:list) {
					System.out.println(product);
				}
				break;
		case 2: 
			final Product product=productController.findOne(1);
			System.out.println(product);
			break;
		case 3: 
			if(productController.findOneAndDelete(2)) {
				System.out.println("Product No: 2 Records Deleted");
			}
			break;
		case 4: 
			final Product updateProduct=productController.findOne(1);
			updateProduct.setpQuantity(14);
			if(productController.findOneAndUpdate(3,updateProduct)) {
				System.out.println("Product No: 3 Records updated");
			}
			break;	
		case 5: 
			final Product newProduct=new Product(3,"adidas-shoe", 98765);
			if(productController.createNew(newProduct)) {
				System.out.println(newProduct+ " Created in DB");
			}
			break;
		default:
			System.out.println("Please select between 1 to 5 options");
			break;
		}
	}

	private static void printproducts(ProductDao dao) throws SQLException {
		final List<Product> list=dao.findAll();
		for(Product a: list) {
			System.out.println(a);
		}
	}
}
