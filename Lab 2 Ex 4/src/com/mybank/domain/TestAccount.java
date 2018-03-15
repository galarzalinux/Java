//Activity Guide Lab 2 Ex 4
package com.mybank.domain;
import com.mybank.test.Account;

public class TestAccount {

	public static void main(String[] args) {
		Account acct=new Account(100.0);
		acct.deposit(47.0);
		acct.withdraw(150.0);
		System.out.println("Final Account Balance is: "+acct.getBalance());
	}

}
