package Animal.Aves;
import Volador.Voladores;
import Animal.Animal;

public class Perico extends Animal implements Voladores{
	
	public String color;
	
	public Perico(String nombre,String color){
		this.nombre=nombre;
		this.color=color;
	}
	
	public void haceRuido(){
		System.out.println("El perico esta chingue y chingue");
	}
	
	public void comer(){
		System.out.println("El perico come");
	}

      public void despegar() { 
      	System.out.println("El perico no puede despegar porque no vuela");
      }

      public void volar() {     
      	System.out.println("El perico no vuela");
      }

      public void aterrizar() {
      	System.out.println("El perico aterriza con un buen madrazo"); 
      }
	
}
