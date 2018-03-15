//Activity Guide  Lab 5  Ex 2
package com.mybank.domain;

public class Customer {

	private String firstname,lastname;
	private Account account;
	
	public Customer(String f, String l){
		firstname=f;
		lastname=l;
	}

	public String getFirstName(){
		return firstname;
	}
	
	public String getLastName(){
		return lastname;
	}
	
	public Account getAccount(){
		return account;
	}
	
	public void setAccount(Account acct){
		account=acct;
	}
}
