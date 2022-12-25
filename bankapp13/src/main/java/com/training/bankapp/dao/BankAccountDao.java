package com.training.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.bankapp.model.BankAccount;

public class BankAccountDao implements IDao<BankAccount> {

	private DbConnection db;
	private static BankAccountDao bankAccountDao;

	private BankAccountDao() {
		super();	
	}

	private BankAccountDao(DbConnection db) {
		super();
		this.db = db;
	}
	public static BankAccountDao getBankAccountDao() {
		if(bankAccountDao==null) {
			synchronized (BankAccountDao.class) {
				if(bankAccountDao==null) {
					bankAccountDao=new BankAccountDao(DbConnection.getDb());
				}
			}
		}
		return bankAccountDao;
	}
	
	public List<BankAccount> findAll() throws SQLException {
		final List<BankAccount> list=new ArrayList<BankAccount>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select accNo,accName,balance from bankaccount";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new BankAccount(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));			
		}
		return list;
	}

	public BankAccount findOne(int id)  throws SQLException{
		
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select accNo,accName,balance from bankaccount where accNo="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final BankAccount account=new BankAccount(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
			return account;
		}
		return null;
	}

	public boolean createNew(BankAccount account)  throws SQLException{
		Connection connect=db.getConnection();		
		final String sql="insert into bankaccount values(?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, account.getAccNo());
		pStatement.setString(2, account.getAccName());
		pStatement.setInt(3,((int) account.getBalance()));
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndDelete(int id)  throws SQLException{
		final Connection connect=db.getConnection();
		final String sql="delete from bankaccount where accNo=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	public boolean findOneAndUpdate(int id, BankAccount account) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update bankaccount set balance=? where accNo=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, ((int)account.getBalance()));
		pStatement.setInt(2, account.getAccNo());
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	
}
