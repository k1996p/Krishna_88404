package com.assignment.ecomapp.model;

public abstract class Product {
	
	private int pId;
	private int pQuantity;
	private String pName;
	private double pPrice;
	private static int count=1;
	
	public Product() {
		super();
	}

	public Product(int pQuantity, String pName, double pPrice) {
		super();
		this.pId = count++;
		this.pQuantity = pQuantity;
		this.pName = pName;
		this.pPrice = pPrice;
	}

	public Product(int pId, int pQuantity, String pName, double pPrice) {
		super();
		this.pId = pId;
		this.pQuantity = pQuantity;
		this.pName = pName;
		this.pPrice = pPrice;
	}

	
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pQuantity=" + pQuantity + ", pName=" + pName + ", pPrice=" + pPrice + "]";
	}

}
