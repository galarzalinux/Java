import java.util.LinkedList;
import java.util.ListIterator;

public class MyLinkedList {

	public static void main(String[] args) {
		LinkedList<String> states=new LinkedList<>();
		states.add("Jalisco");
		states.add("Nayarit");
		states.add("Quintana Roo");
		states.add("Veracruz");
		states.add("Guerrero");
		states.add("Nuevo Leon");
		states.add("Colima");
		states.addFirst("San Luis Potosi");
		System.out.println(states);
		System.out.println("The las state is = "+states.getLast());
		ListIterator<String> literator=states.listIterator(states.size());
		while (literator.hasPrevious()) {
			System.out.println(literator.previous());
		}
		while (literator.hasNext()) {
			System.out.println(literator.next());
		}
	}
}
