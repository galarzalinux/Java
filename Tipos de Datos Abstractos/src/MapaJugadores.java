import java.util.*;
public class  MapaJugadores{
	HashMap<String, String> jugadores;
	
	public MapaJugadores() {
		jugadores = new HashMap<String, String> ();
	}
	public String get(String posicion) {
		String juagador = jugadores.get(posicion);
		return juagador;
	}
	public void put(String posicion, String nombre) {
		jugadores.put(posicion, nombre);
	}
	
	public static void main(String args[]){
		MapaJugadores equipo=new MapaJugadores();
		equipo.put("delantero", "El Chicharito");
		equipo.put("portero", "Jorge Campos");
		equipo.put("lateral derecho", "El Messi");	
		
		System.out.println("El delantero es: "+ equipo.get("delantero"));
		System.out.println("El portero es: "+ equipo.get("portero"));
		System.out.println("El lateral derecho es: "+ equipo.get("lateral derecho"));	
	}
}
