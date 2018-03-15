//Activity Guide  Lab 6  Ex 1
package com.mybank.domain;

public class Bank {

	private Customer[] customers;
	private int numberOfCustomers;
	private final int MAX=5;
	
	public Bank() {
		customers=new Customer[MAX];
		numberOfCustomers=0;
	}
	
	public void addCustomer(String f,String l){
		customers[numberOfCustomers++]=new Customer(f, l);
	}
	
	public int getNumOfCustomers(){
		return numberOfCustomers;
	}
	
	public Customer getCustomer(int index){
		return customers[index];
	}

}
