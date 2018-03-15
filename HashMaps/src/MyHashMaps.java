import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MyHashMaps {

	public static void main(String[] args) {
		Scanner scanf=new Scanner(System.in);
		Map<Integer, String> miMapa=new HashMap<Integer, String>(); 
		int opc,opcsub,llave;
		String valor;
		boolean continuar=true;
		do{
			System.out.println("Menu\n\n1.-Insertar\n2.-Mostrar");
			System.out.println("3.-Eliminar\n4.-Editar\n5.-Salir");
			opc=scanf.nextInt();
			switch (opc) {
				case 1://Insertar Valores
					System.out.println("Teclea una Llave numerica");
					llave=scanf.nextInt();
					if(!miMapa.containsKey(llave)){
						System.out.println("Teclea el Valor para la Llave "+llave);
						valor=scanf.next();
						miMapa.put(llave, valor);
					}else{
						System.out.println("Esa Llave ya existe!");
					}
					break;
				case 2://Mostrar valores
					System.out.println("1.-Mostrar Todos los Elementos"
							+ "\n2.-Mostrar solo un Elemento");
					opcsub=scanf.nextInt();
					switch (opcsub) {
						case 1://Todos los que se encuentren
							if(!miMapa.isEmpty()){
								Iterator<Integer> it=miMapa.keySet().iterator();
								while (it.hasNext()) {
									Integer key=it.next();
									System.out.println("Llave: "+key
											+ " Valor: "+miMapa.get(key));
								}
							}else{
								System.out.println("No hay ningun elemnto");
							}							
							break;
						case 2://Solo uno
							System.out.println("Teclea una Llave a buscar");
							llave=scanf.nextInt();
							if(!miMapa.isEmpty()&&miMapa.containsKey(llave)){
								System.out.println("Llave: "+llave
										+ " Valor: "+miMapa.get(llave));
							}else{
								System.out.println("No existe esa Llave");
							}
							break;
						default:
							System.out.println("Opcion no valida");
							break;
					}
					break;
				case 3://Eliminar Valores
					System.out.println("1.-Elimina Todos los Elementos"
							+ "\n2.-Elimina solo un Elemento");
					opcsub=scanf.nextInt();
					switch (opcsub) {
						case 1://Todos los que se encuentren
							if(!miMapa.isEmpty()){
								miMapa.clear();
								System.out.println("Hash Map Vacio");
							}else{
								System.out.println("No hay ningun elemnto");
							}							
							break;
						case 2://Solo uno
							System.out.println("Teclea una Llave a buscar");
							llave=scanf.nextInt();
							if(!miMapa.isEmpty()&&miMapa.containsKey(llave)){
								System.out.println("Llave: "+llave
										+ " Valor: "+miMapa.get(llave)
										+"\nHa sido Eliminada");	
								miMapa.remove(llave);
							}else{
								System.out.println("No existe esa Llave");
							}
							break;
						default:
							System.out.println("Opcion no valida");
							break;
					}
					break;
				case 4:
					System.out.println("Teclea una Llave numerica");
					llave=scanf.nextInt();
					if(miMapa.containsKey(llave)){
						System.out.println("Teclea el nuevo Valor para la Llave "+llave);
						valor=scanf.next();
						miMapa.put(llave, valor);
					}else{
						System.out.println("Esa Llave no existe!");
					}
					break;
				case 5:
					continuar=false;
					scanf.close();
					break;

				default:
					System.out.println("Opcion no valida");
					break;
			} 
		}while(continuar);
		scanf.close();
	}
}
