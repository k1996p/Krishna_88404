package com.assignment.ecomapp.modal;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	private String custName;
	private double custWalletBal;
	private String custEmail;

	public Customer() {
		super();
	}

	public Customer(String custName, double custWalletBal, String custEmail) {
		super();
		this.custName = custName;
		this.custWalletBal = custWalletBal;
		this.custEmail = custEmail;
	}

	public Customer(int custId, String custName, double custWalletBal, String custEmail) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custWalletBal = custWalletBal;
		this.custEmail = custEmail;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getCustWalletBal() {
		return custWalletBal;
	}

	public void setCustWalletBal(double custWalletBal) {
		this.custWalletBal = custWalletBal;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custWalletBal=" + custWalletBal
				+ ", custEmail=" + custEmail + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(custId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return custId == other.custId;
	}
}
