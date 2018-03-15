//Activity Guide  Lab 7  Ex 1
package com.mybank.domain;

public class Customer {

	private String firstname,lastname;
	private Account[] accounts;
	private Account account;
	private int numberOfAccount;
	private final int MAX=10;

	public Customer(String f, String l){
		firstname=f;
		lastname=l;
		accounts=new Account[MAX];
		numberOfAccount=0;;
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

	public int getNumOfAccounts() {
		return numberOfAccount;
	}

	public Account getAccount(int acct_idx) {
		return accounts[acct_idx];
	}

	public void addAccount(Account acct) {
		accounts[numberOfAccount++]=acct;
	}
}
