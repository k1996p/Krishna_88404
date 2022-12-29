package com.assignment.ecomapp.controller;

import java.sql.SQLException;
import java.util.List;

import com.assignment.ecomapp.modal.Product;

public class ProductController implements IController<Product> {

	private static ProductController productController;
	private ProductCollection productCollection;

	private ProductController() {
		super();
		this.productCollection = ProductCollection.getProductCollection();
	}

	public static ProductController getProductController() {
		if (productController == null) {
			synchronized (ProductController.class) {
				if (productController == null) {
					productController = new ProductController();
				}

			}
		}
		return productController;
	}

	public List<Product> findAll() throws SQLException {

		return productCollection.findAll();
	}

	public Product findOne(int id) throws SQLException {

		return productCollection.findOne(id);
	}

	public boolean createNew(Product Product) throws SQLException {

		return productCollection.createNew(Product);
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		
		return productCollection.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, Product Product) throws SQLException {

		return productCollection.findOneAndUpdate(id, Product);
	}

}
