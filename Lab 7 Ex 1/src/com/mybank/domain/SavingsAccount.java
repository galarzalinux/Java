//Activity Guide  Lab 7  Ex 1
package com.mybank.domain;

public class SavingsAccount extends Account{

	private double interestRate;
	
	public SavingsAccount(double initBalance,double interestRate) {
		super(initBalance);
		this.interestRate=interestRate;
		balance+=(balance*interestRate);
	}

}
