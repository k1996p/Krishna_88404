package com.ecommerce.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	private int itemQuantity;
	private double itemTotalPrice;
	@OneToOne
	@JoinColumn(name = "pId")
	private Product product;
	
	public OrderItem() {
		super();
	}

	public OrderItem(int itemQuantity, Product product) {
		super();
		this.itemQuantity = itemQuantity;
		this.product = product;
		this.itemTotalPrice = product.getpPrice()*itemQuantity;
		
	}

	public OrderItem(int itemId, int itemQuantity, double itemTotalPrice, Product product) {
		super();
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
		this.itemTotalPrice = itemTotalPrice;
		this.product = product;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getItemTotalPrice() {
		return itemTotalPrice;
	}

	public void setItemTotalPrice(double itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", itemQuantity=" + itemQuantity + ", itemTotalPrice=" + itemTotalPrice
				+ ", product=" + product + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return itemId == other.itemId;
	}
	
	
	
}
