//Activity Guide Lab 2 Ex 4
package com.mybank.test;


public class Account {
	
	private double balance;
	
	public Account(double initBalance){
		balance=initBalance;
	}
	
	public double getBalance(){
		return balance;
	}

	public void deposit(double amt){
		balance+=amt;
	}

	public void withdraw(double amt){
		if(balance-amt>0)
			balance-=amt;
	}
		
}
