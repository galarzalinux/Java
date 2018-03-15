import java.util.*;
public class ArrayListExample{

	public static void main(String args[]){
		List test = new ArrayList();
		test.add(new Integer(5));
		test.add(new Integer(55));
		test.add(new Integer(42));
		test.add(4);
		/*
		System.out.println(test.size());
		System.out.println(test.get(0));
		System.out.println(test.contains(42));
		System.out.println(test.contains("hihi"));
		System.out.println(test.size());
		System.out.println(test);
		*/
		Iterator itera=test.iterator();
		while (itera.hasNext()) {
	             System.out.print(itera.next()+",");
            }
		
		for (Object object : test) {
			System.out.print("  "+object+" ");
            }
		
		System.out.println(test);
	}
}