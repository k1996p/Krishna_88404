package com.assignment.ecomapp.modal;

public class Product {
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

		
		@Override
		public String toString() {
			return "Product [pId=" + pId + ", pQuantity=" + pQuantity + ", pName=" + pName + ", pPrice=" + pPrice + "]";
		}

		public String add(int quantity) {
			this.pQuantity=this.pQuantity+quantity;
			this.pPrice=this.pPrice*this.pQuantity;
			return quantity+" unit of "+this.pName+" added with new quantity "+this.pQuantity+" new price is "+this.pPrice;
		}
		public String remove(int quantity) {
			this.pQuantity=this.pQuantity-quantity;
			this.pPrice=this.pPrice;
			return quantity+" unit of "+ this.pName+" removed with new quantity "+this.pQuantity+" new price is "+this.pPrice;
		}
		
}
