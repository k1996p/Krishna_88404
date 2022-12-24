package com.assignment.ecomapp.modal;

public class Product {
		private int pId;
		private String pName;
		private double pPrice;
		private static int count=1;
		
		public Product() {
			super();
		}
		
		
		public Product(String pName, double pPrice) {
			super();
			this.pId=count++;
			this.pName = pName;
			this.pPrice = pPrice;
		}

		public Product(int pId, String pName, double pPrice) {
			super();
			this.pId = pId;
			this.pName = pName;
			this.pPrice = pPrice;
		}

		@Override
		public String toString() {
			return "Product [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + "]";
		}


		public String add(double pPrice) {
			return null;
		}
		
		public String remove(double pPrice) {
			return null;
		}
		
}
