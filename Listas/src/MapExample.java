import java.util.*;
public class MapExample {
	public static void main(String args[]) {
		Map map = new HashMap();
		Set<String> temp=new HashSet<String>();
		
		map.put("uno",new Moof(1));
		map.put("dos",new Moof(2));
		map.put("tres",new Moof(3));
		map.put("cuatro",new Moof(4));
		map.put("cinco",new Moof(5));
		map.put("seis",new Moof(6));
		map.put("siete",new Moof(7));
		map.put("uno",new Moof(4));
		map.put(null, new Moof(10));

		temp.add("cuatro");
		temp.add("dos");
		temp.add("seis");	
		temp.add("uno");
		temp.add("tres");
		temp.add("hola");
		temp.add("mundo");
		temp.add("cinco");
		temp.add("tres");
		
		
		System.out.println(temp);
/*
		//Devuelve el conjunto de las claves
		Set set1 = map.keySet();
		//Devuelve la vista Collection de los valores
		Collection collection = map.values();
		//Devuelve el conjunto de las asignaciones de las clave
		Set set2 = map.entrySet();
		System.out.println(map + "\n" +set1 + "\n" + collection + "\n" + set2);
		*/
	}
}
