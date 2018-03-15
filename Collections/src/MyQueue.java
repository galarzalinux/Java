import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

	public static void main(String[] args) {
		int i;
		Queue<Integer> cola=new LinkedList<>();		
		for (i=0; i<10; i++) {
			cola.add(i);
		}		
		System.out.println("Elements in Queue = "+cola);
		System.out.println("Unqueue first element = "+cola.poll());
		System.out.println("Elements in Queue = "+cola);
	}
}