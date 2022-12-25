package com.training.bankapp.controller;

import java.sql.SQLException;
import java.util.List;

import com.training.bankapp.dao.BankAccountDao;
import com.training.bankapp.dao.DbConnection;
import com.training.bankapp.model.BankAccount;

public class BankAccountCollection implements ICollection<BankAccount> {
	
	private static BankAccountCollection collection;
	private BankAccountDao dao;
	private List<BankAccount> accountList;
//	private BankAccountCollection() throws SQLException {
//		this.dao=BankAccountDao.getBankAccountDao();
//		this.accountList=dao.findAll();
//	}

	private BankAccountCollection() {
		this.dao=BankAccountDao.getBankAccountDao();
	}

	public static BankAccountCollection getBankCollection() {
		if(collection==null) {
			synchronized (BankAccountCollection.class) {
				if(collection==null) {
					collection=new BankAccountCollection();
				}
				
			}
		}
		return collection;
	}

	public List<BankAccount> findAll() throws SQLException {
		accountList=dao.findAll();
		return accountList;
	}

	public BankAccount findOne(int id) throws SQLException {
		BankAccount account=dao.findOne(id);
		return account;
	}


	public boolean findOneAndDelete(int id) throws SQLException {
		
		return dao.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, BankAccount account) throws SQLException {
		return dao.findOneAndUpdate(id, account);
	}
	

	public boolean createNew(BankAccount account) throws SQLException {
		
		return dao.createNew(account);
	}
}
