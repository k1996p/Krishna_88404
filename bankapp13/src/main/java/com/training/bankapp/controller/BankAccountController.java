package com.training.bankapp.controller;

import java.sql.SQLException;
import java.util.List;

import com.training.bankapp.model.BankAccount;

public class BankAccountController implements IController<BankAccount> {

		private static BankAccountController accountController;
		private BankAccountCollection accountCollection;
		private BankAccountController() {
			super();
			this.accountCollection=BankAccountCollection.getBankCollection();
		}
		public static BankAccountController getAccountController() {
			if(accountController==null) {
				synchronized (BankAccountController.class) {
					if(accountController==null) {
						accountController= new BankAccountController();
					}
					
				}
			}
			return accountController;
		}
		public List<BankAccount> findAll() throws SQLException {
			
			return accountCollection.findAll();
		}
		public BankAccount findOne(int id) throws SQLException {

			return accountCollection.findOne(id);
		}
		public boolean createNew(BankAccount account) throws SQLException {
			// TODO Auto-generated method stub
			return accountCollection.createNew(account);
		}
		public boolean findOneAndDelete(int id) throws SQLException {
			return accountCollection.findOneAndDelete(id);
		}
		public boolean findOneAndUpdate(int id, BankAccount account) throws SQLException {

			return accountCollection.findOneAndUpdate(id, account);
		}
		
		
}
