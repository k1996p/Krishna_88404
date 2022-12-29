package com.assignment.greeting;

import com.assignment.greeting.modal.Greeting;

public class GreetingApp {

	public static void main(String[] args) {
			Greeting greeting = new Greeting(); 
			System.out.println(greeting.greet());
			
			 greeting = new Greeting() {

				@Override
				public String greet() {
					return "Welcome Lambda";
				}
				 
			 }; 
			System.out.println(greeting.greet());
	}

}
