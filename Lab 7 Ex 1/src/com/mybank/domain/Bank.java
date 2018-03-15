//Activity Guide  Lab 7  Ex 1
package com.mybank.domain;

public class Bank {

	private static Customer[] customers;
	private static int numberOfCustomers;
	private static final int MAX=5;
	
	static{
		customers=new Customer[MAX];
		numberOfCustomers=0;
	}
	
	private Bank() {

	}

	public static void addCustomer(String f,String l){
		customers[numberOfCustomers++]=new Customer(f, l);
	}

	public static int getNumOfCustomers(){
		return numberOfCustomers;
	}

	public static Customer getCustomer(int index){
		return customers[index];
	}

}
