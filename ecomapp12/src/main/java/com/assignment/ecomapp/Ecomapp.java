package com.assignment.ecomapp;

import java.sql.SQLException;
import java.util.List;

import com.assignment.ecomapp.dao.DbConnection;
import com.assignment.ecomapp.dao.ProductDao;
import com.assignment.ecomapp.modal.Product;

public class Ecomapp {

	public static void main(String[] args) {
		try {
			final DbConnection db=DbConnection.getDb();
			final  ProductDao dao=new ProductDao(db);
			
//			Display all products			
			printProduct(dao);
			
//			Find by pId
			System.out.println("Find Product by pId");
			final Product item=dao.findOne(1);
			System.out.println(item);
			
//			Create new Product
			System.out.println("After New Product added");
			final Product newItem=new Product(5,"wrong-shoe",800);
			if(dao.createNew(newItem)) {
				System.out.println(newItem+" Created ");
			}else {
				System.out.println(newItem+" Not Created ");
			}
			printProduct(dao);
			
//			Deleting a existing product
			System.out.println("After Delete");
			if(dao.findOneAndDelete(3)) {
				System.out.println("Product No :  records deleted");
			}
			printProduct(dao);
			
//			Updating a product
			System.out.println("After update");
			item.setpQuantity(9);
			if(dao.findOneAndUpdate(1,item)) {
				System.out.println(item+" updated");
			}
			printProduct(dao);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printProduct(ProductDao dao) throws SQLException {
		final List<Product> list=dao.findAll();

		for( Product a: list) {
			System.out.println(a);
		}
	}

}
