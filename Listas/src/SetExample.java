import java.util.*;

public class SetExample {
	public static void main(String[] args) {
		
	//	Set set = new HashSet();//Acomoda los elementos menor a mayor, no acepta duplicados.
		Set set=new TreeSet();//Acomoda los valores de mayor a menor. no acepta duplicados.
	//	Set set=new LinkedHashSet();//Acomoda los elementos como fueron llegando, no acepta duplicados.
		set.add(new Moof(5));
		set.add(new Moof(1));
		set.add(new Moof(2));
		set.add(new Moof(3));
		set.add(new Moof(4));
		set.add(new Moof(5));
		set.add(new Moof(6));
		set.add(new Moof(4));
		System.out.println(set);
		
		
	}
}
