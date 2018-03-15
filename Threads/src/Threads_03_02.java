import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threads_03_02 {

	public static void main(String[] args) {
		//creating a pool of 5 threads  
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i =1; i <=100; i++) {  
			Runnable worker = new WorkerThread("I'm thread " + i);  
			//calling execute method of ExecutorService
			executor.execute(worker);  
		}  
		executor.shutdown();  
		while (!executor.isTerminated()) {   }  

		System.out.println("Finished all threads");  
	}
}