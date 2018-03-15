import java.util.*;
public class ListExample {
	public static void main(String[] args) {
		List list = new LinkedList();
		list.add("one");
		list.add("second");
		list.add("3rd");
		list.add(new Double(5.25484));
		list.add(new Integer(4));
		list.add(new Float(5.0F));
		list.add("second"); // duplicados son agregados
		list.add(new Integer(4)); // duplicate son agregados
		System.out.println(list);
	}
}
