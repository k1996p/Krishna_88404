package com.training.bankapp.controller;

import java.util.HashSet;
import java.util.Set;

import com.training.bankapp.modal.BankAccount;

public abstract class BankCollection<T> {

	protected final Set<T> accountSet = new HashSet<>();

	protected BankCollection() {
		super();
	}

	public Set<T> getAccountset() {
		return accountSet;
	}

	public abstract String createNewAccount(T account);

	public abstract String updateAccNameByAccNo(int accNo, String accName);

	public abstract T findByAccNo(int accNo);

}
