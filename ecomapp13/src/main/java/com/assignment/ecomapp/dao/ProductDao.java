package com.assignment.ecomapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.assignment.ecomapp.modal.Product;

public class ProductDao implements IDao<Product> {

	private DbConnection db;
	private static ProductDao productDao;

	private ProductDao() {
		super();
	}

	public ProductDao(DbConnection db) {
		super();
		this.db = db;
	}

	public static ProductDao getProductDao() {
		if (productDao == null) {
			synchronized (ProductDao.class) {
				if (productDao == null) {
					productDao = new ProductDao(DbConnection.getDb());
				}
			}
		}
		return productDao;
	}

	public List<Product> findAll() throws SQLException {
		final List<Product> list = new ArrayList<Product>();
		Connection connect = db.getConnection();
		Statement statement = connect.createStatement();
		final String sql = "select pId,pQuantity,pName,pPrice from product";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			list.add(
					new Product(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getInt(4)));
		}
		return list;
	}

	public Product findOne(int id) throws SQLException {
		Connection connect = db.getConnection();
		Statement statement = connect.createStatement();
		final String sql = "select pId,pQuantity,pName,pPrice from product where pId=" + id;
		ResultSet resultSet = statement.executeQuery(sql);
		if (resultSet.next()) {
			final Product product = new Product(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
					resultSet.getInt(4));
			return product;
		}
		return null;
	}

	public boolean createNew(Product product) throws SQLException {
		Connection connect = db.getConnection();
		final String sql = "insert into Product values(?,?,?,?)";
		final PreparedStatement pStatement = connect.prepareStatement(sql);
		pStatement.setInt(1, product.getpId());
		pStatement.setInt(2, product.getpQuantity());
		pStatement.setString(3, product.getpName());
		pStatement.setInt(4, ((int) product.getpPrice()));
		if (pStatement.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndDelete(int pId) throws SQLException {
		final Connection connect = db.getConnection();
		final String sql = "delete from Product where pId=?";
		final PreparedStatement pStatement = connect.prepareStatement(sql);
		pStatement.setInt(1, pId);
		if (pStatement.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndUpdate(int pId, Product product) throws SQLException {
		final Connection connect = db.getConnection();
		final String sql = "update set pQuantity=? where pId=?";
		final PreparedStatement pStatement = connect.prepareStatement(sql);
		pStatement.setInt(1, product.getpQuantity());
		pStatement.setInt(2, product.getpId());
		if (pStatement.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

}
