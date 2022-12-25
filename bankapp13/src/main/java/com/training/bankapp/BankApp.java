package com.training.bankapp;

import java.sql.SQLException;
import java.util.List;

import com.training.bankapp.controller.BankAccountCollection;
import com.training.bankapp.controller.BankAccountController;
import com.training.bankapp.dao.BankAccountDao;
import com.training.bankapp.dao.DbConnection;
import com.training.bankapp.model.BankAccount;

public class BankApp {

	public static void main(String[] args) {
		try {
			final BankAccountController accountController=
					BankAccountController.getAccountController();
			System.out.println("1. Displa all Accoutns");
			System.out.println("2. Account Details by AccNo");
			System.out.println("3. Delete Account by AccNo");
			System.out.println("4. Update Balace by AccNO");
			
			int choice=1;
			System.out.println("1. Displa all Accoutns");
			mainOptions(accountController, choice);
			
			System.out.println("2. Account Details by AccNo");
			choice=2;
			mainOptions(accountController, choice);
			
			System.out.println("3. Delete Account by AccNo");
			choice=3;
			mainOptions(accountController, choice);
			
			System.out.println("4. Update Balace by AccNO");
			choice=4;
			mainOptions(accountController, choice);
			choice=1;
			System.out.println("1. Displa all Accoutns");
			mainOptions(accountController, choice);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void mainOptions(final BankAccountController accountController, int choice) throws SQLException {
		switch(choice) {
		case 1: 
				List<BankAccount> list=accountController.findAll();
				for(BankAccount account:list) {
					System.out.println(account);
				}
				break;
		case 2: 
			final BankAccount account=accountController.findOne(1);
			System.out.println(account);
			break;
		case 3: 
			if(accountController.findOneAndDelete(3)) {
				System.out.println("Acc No: 3 Records Deleted");
			}
			break;
		case 4: 
			final BankAccount updatAccount=accountController.findOne(1);
			updatAccount.setBalance(1234);
			if(accountController.findOneAndUpdate(3,updatAccount)) {
				System.out.println("Acc No: 3 Records Deleted");
			}
			break;	
		case 5: 
			final BankAccount newAccount=new BankAccount("Amitabh", 98765);
			if(accountController.createNew(newAccount)) {
				System.out.println(newAccount+ " Created in DB");
			}
			break;
		default:
			System.out.println("Please select between 1 to 5 options");
			break;
		}
	}

	private static void printAccounts(BankAccountDao dao) throws SQLException {
		final List<BankAccount> list=dao.findAll();
		for(BankAccount a: list) {
			System.out.println(a);
		}
	}

}
