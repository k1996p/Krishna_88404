package com.assignment.ecomapp.modal;

public class Product {
		protected int pId;
		protected int pQuantity;
		protected String pName;
		protected double pPrice;
		private static int count=1;
		
		public Product() {
			super();
		}
	
		public Product(int pQuantity, String pName, double pPrice) {
			super();
			this.pId=count++;
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + pId;
			return result;
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
			if (pId != other.pId)
				return false;
			return true;
		}
		
}
