//Activity Guide Lab 2 Ex 3
public class TestAccount {

	public static void main(String[] args) {
	      Account acct=new Account(100.0);
	      acct.deposit(47.0);
	      acct.withdraw(150.0);
	      System.out.println("Final Account Balance is: "+acct.getBalance());
      }
}
