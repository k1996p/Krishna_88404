package com.assignment.ecomapp;

import com.assignment.ecomapp.modal.IEcomService;

public class Ecomapp {

	public static void main(String[] args) {

		IEcomService service=new IEcomService() {

			public boolean add(int pQunatity) {
				System.out.println("ADD");
				return false;
			}

			public boolean remove(int pQunatity) {
				System.out.println("REMOVE");
				return false;
			}			
		};
	}

}
