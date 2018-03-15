/*
 * This program demonstrates how to lock an object using synchronization
 */

/**
 *
 * @author MFisher
 */
public class CountdownMain {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		Countdown CD = new Countdown();
		Runnable r = () -> {
			synchronized(CD) {
				CD.printCount();
			}
		};
		Thread one = new Thread(r,"aaa");
		Thread two = new Thread(r,"bb");
		one.start();
		two.start();
	}
}   

