import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MultiHashMaps {
	Map<String, String> miMultiMapa=new HashMap<String, String>();
	static Scanner scanf=new Scanner(System.in);
	static final String DELIMITADOR=",";

	public void inserta(String key,String value){
		if(miMultiMapa.containsKey(key)){//Valida si existe la Llave.
			System.out.println("Se agrego: "+value+" a la Llave: "+key);
			//Concatena el nuevo valor a los anteriores y agrega un delimitador.
			value=miMultiMapa.get(key)+value+DELIMITADOR;
			//Sobreescribe la Lave con los nuevos valores.
			miMultiMapa.put(key, value);
		}else{//De lo contrario.
			System.out.println("Llave "+key+" creada con valor "+value);
			value+=DELIMITADOR;//Agreaga al final de la cadena un separador.
			miMultiMapa.put(key, value);//Crea los nuevos Llave y Valor.
		}
	}

	public void mostrar(int opc){
		switch (opc) {
			case 1://Imprime solo uno
				System.out.println("Teclea una Llave a Buscar");
				String key=scanf.next();
				if(!miMultiMapa.isEmpty()&&miMultiMapa.containsKey(key)){
					//Valida que no este vacio y que se encuentre presenta la Llave.
					System.out.println("Llave: "+key
							+ " Valor: "+miMultiMapa.get(key));
				}else{//De lo contrario.
					System.out.println("No existe esa Llave");
				}
				break;
			case 2://Imprime todos los que se encuentren.
				if(!miMultiMapa.isEmpty()){//Valida que tenga elementos.
					//Crea un Iterator para recorrer todo el HashMap.
					Iterator<String> it=miMultiMapa.keySet().iterator();
					while(it.hasNext()) {//Mientras tenga Elementos.
						String keyS=it.next();
						System.out.println("Llave: "+keyS
								+ " Valor: "+miMultiMapa.get(keyS));
					}
				}else{//De lo contrario
					System.out.println("No hay ningun elemnto");
				}							
				break;
			default:
				System.out.println("Opcion no valida");
				break;
		}
	}

	public void elimina(int opc){
		String key;
		switch (opc) {
			case 1://Elimina una Llave con su contenido.
				System.out.println("Teclea la Llave a Eliminar");
				key=scanf.next();
				if(!miMultiMapa.isEmpty()&&miMultiMapa.containsKey(key)){
					//Valida que no este vacio y que se encuentre presenta la Llave.
					miMultiMapa.remove(key);//Elimina la Llave y su contenido.
				}else{//De lo contrario.
					System.out.println("No existe esa Llave");
				}
				break;
			case 2://Elimina un Elemento de una Llave.
				System.out.println("Teclea la Llave del elemento a Eliminar");
				key=scanf.next();
				if (!miMultiMapa.isEmpty()&&miMultiMapa.containsKey(key)){
					//Valida que no este vacio y que se encuentre presenta la Llave.
					String[] stringarray=miMultiMapa.get(key).split(DELIMITADOR);
					//Convierte el contenido d la Llave en un areglo de Strings.
					String value,newvalue="";
					boolean existe=false;
					System.out.println("La Llave "+key+" contiene los"
							+ " siguientes elementos");
					System.out.println(miMultiMapa.get(key));
					//Imprime el contenido de la Llave.
					System.out.println("Cual deseas eliminar");
					value=scanf.next();
					for (String tmp : stringarray) {
						//Busca si existe el elemento.
						System.out.print(tmp+"||");
						if(value.equalsIgnoreCase(tmp)){
							existe=true;//Asigna True si es que hay coincidencia.
						}
					}
					if(existe){//Si se encontro el valor a eliminar.
						for (String tmpcp : stringarray) {//Itera en el arreglo de Strings.
							if(!value.equalsIgnoreCase(tmpcp)){
								//Copia todos los valores, excepto el que se quiere eliminar.
								newvalue=newvalue+tmpcp+DELIMITADOR;
							}
						}
						miMultiMapa.put(key, newvalue);
						//Reintroduce los valores para la Llave
					}else{
						System.out.println("Error ese valor no existe");
					}
				}else{
					System.out.println("No existe esa Llave");
				}
				break;
			case 3://Elimina el contenido de una Llave.
				System.out.println("Teclea la Llave de la que quieres dejar vacia");
				key=scanf.next();
				if(!miMultiMapa.isEmpty()&&miMultiMapa.containsKey(key)){
					//Valida que no este vacio y que se encuentre presente la Llave.
					miMultiMapa.put(key, "");
				}else{//De lo contrario.
					System.out.println("La Llave no existe");
				}
				break;
			case 4://Elimina todo lo que tiene el HashMap.
				System.out.println("MultiHashMap Vacio");
				if(miMultiMapa.isEmpty()){//Verifica si esta vacia.
					System.out.println("El HashMap no contiene ningun elemento");
				}else{//De lo contrario.
					miMultiMapa.clear();//Elimina todo el contenido.					
					System.out.println("El HashMap ahora esta vacio");
				}
				break;
			default:
				System.out.println("Opcion no valida");
				break;
		}
	}

	public void edita(int opc){

	}

	public static void main(String[] args) {
		MultiHashMaps mhm=new MultiHashMaps();
		int opc;
		String key,value;
		boolean continuar=true;
		do {
			System.out.println("Menu MultiHashMaps\n\n1.-Insertar"
					+ "\n2.-Mostrar\n3.-Eliminar\n4.-Editar\n5.-Salir");
			opc=scanf.nextInt();
			switch (opc) {
				case 1://Inserta
					System.out.println("Teclea el nombre de la Llave");
					key=scanf.next();
					System.out.println("Teclea el valor a insetar en Lave :"+key);
					value=scanf.next();
					mhm.inserta(key, value);
					break;
				case 2:
					System.out.println("1.-Mostrar los Elementos de una Llave"
							+ "\n2.-Mostrar todos los Elementos de todas las Llaves");
					opc=scanf.nextInt();
					mhm.mostrar(opc);
					break;
				case 3:
					System.out.println("1.-Elimiar una Llave"
							+ "\n2.-Eliminar un elemento de una Llave"
							+ "\n3.-Eliminar todos los elementos de una Llave"
							+ "\n4.-Eliminar todo el contenido");
					opc=scanf.nextInt();
					mhm.elimina(opc);
					break;
				case 4:
					System.out.println("1.-Edita un elemento de una Llave"
							+ "\n3.-Eliminar todos los elementos de una Llave"
							+ "\n4.-Eliminar todo el contenido");
					opc=scanf.nextInt();
					mhm.edita(opc);
					break;
				case 5:
					continuar=false;
					scanf.close();
					break;

				default:
					System.out.println("Opcion no valida");
					break;
			}
		} while (continuar);
		scanf.close();
	}

}
