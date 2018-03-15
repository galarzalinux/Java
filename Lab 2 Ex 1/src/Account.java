//Activity Guide Lab 2 Ex 1
public class Account {
	public double balance;

	public Account(double initBalance) {
		balance=initBalance;
	}

	public double getBalance(){
		return balance;
	}

	public void deposit(double amt){
		balance+=amt;
	}

	public void withdraw(double amt){
		balance-=amt;
	}
}
