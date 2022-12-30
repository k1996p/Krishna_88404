package com.ecommerce.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	private String pName;
	private double pPrice;

	public Product() {
		super();
	}

	public Product(String pName, double pPrice) {
		super();
		this.pName = pName;
		this.pPrice = pPrice;
	}

	public Product(int pId, String pName, double pPrice) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
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
		return "Product [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return pId == other.pId;
	}

}
