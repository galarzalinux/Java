//Activity Guide  Lab 5  Ex 2
package com.mybank.domain;

public class Account {

	private double balance;

	public Account(double initBalance){
		balance=initBalance;
	}

	public double getBalance(){
		return balance;
	}

	public boolean deposit(double amt){
		balance+=amt;
		return true;
	}

	public boolean withdraw(double amt){
		boolean result=false;
		if(balance>=amt){
			balance-=amt;
			result=true;
		}
		return result;
	}

}
