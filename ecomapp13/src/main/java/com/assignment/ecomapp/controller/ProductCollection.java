package com.assignment.ecomapp.controller;

import java.sql.SQLException;
import java.util.List;

import com.assignment.ecomapp.dao.DbConnection;
import com.assignment.ecomapp.dao.ProductDao;
import com.assignment.ecomapp.modal.Product;

public class ProductCollection implements ICollection<Product> {

	private static ProductCollection collection;
	private ProductDao dao;
	private List<Product> productList;
//	private ProductCollection() throws SQLException {
//		this.dao=ProductDao.getProductDao();
//		this.productList=dao.findAll();
//	}

	private ProductCollection() {
		this.dao = ProductDao.getProductDao();
	}

	public static ProductCollection getProductCollection() {
		if (collection == null) {
			synchronized (ProductCollection.class) {
				if (collection == null) {
					collection = new ProductCollection();
				}

			}
		}
		return collection;
	}

	public List<Product> findAll() throws SQLException {
		productList = dao.findAll();
		return productList;
	}

	public Product findOne(int id) throws SQLException {
		Product product = dao.findOne(id);
		return product;
	}

	public boolean findOneAndDelete(int id) throws SQLException {

		return dao.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, Product product) throws SQLException {

		return dao.findOneAndUpdate(id, product);
	}

	public boolean createNew(Product product) throws SQLException {

		return dao.createNew(product);
	}
}
