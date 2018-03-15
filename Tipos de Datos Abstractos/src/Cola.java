import java.util.*;
public class Cola {
	
	public static void main(String[] args) {
		Queue<String> cola=new PriorityQueue<String>();
		//cola.add("cadena"); mete un valor en la  PriorityQueue.
		//cola.peek(); muestra el primer valor de la cola.
		//cola.poll(); muestra el primer valor de la cola y lo elimina de la cola;
		cola.add("D");
		cola.add("B");
		cola.add("A");
		cola.add("G");
		cola.add("E");
		cola.add("C");
		cola.add("F");
		cola.add("Z");
		cola.add("X");
		//cola.add("H");
		
		for (String string : cola) {
			System.out.println(string);
		}
		System.out.println(cola);
		System.out.println(cola.poll());
		System.out.println(cola);
		System.out.println(cola.poll());
		System.out.println(cola);
		System.out.println(cola.poll());
		System.out.println(cola);
		System.out.println(cola.poll());
		System.out.println(cola);
		System.out.println(cola.poll());
		System.out.println(cola);
		System.out.println(cola.poll());
		System.out.println(cola);
		System.out.println(cola.poll());
		System.out.println(cola);
		System.out.println(cola.poll());
		System.out.println(cola);
		
	}
}