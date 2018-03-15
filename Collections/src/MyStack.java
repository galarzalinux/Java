import java.util.Stack;

public class MyStack {

	public static void main(String[] args) {
		int i;
		Stack<Integer> pila=new Stack<Integer>();
		for (i = 0;i<10; i++) {
			pila.push(i);
		}
		while (!pila.isEmpty()) {
			System.out.print(" "+pila.pop());
		}
	}
}