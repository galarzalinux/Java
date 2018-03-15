public class LambdaThreads {

	static Runnable r=()->{
		try {
			System.out.println("Delay testing");
			Thread.sleep((int)(Math.random()*2000));
		} catch (Exception e) {
			System.out.println("Error = "+e);
		}
	};

	public static void main(String[] args) {	
		Thread t=new Thread(r);
		t.start();
		new Thread(r).start();
	}
}