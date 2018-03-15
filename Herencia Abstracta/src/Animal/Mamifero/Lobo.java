package Animal.Mamifero;
import Animal.Animal;

public class Lobo extends Animal{

	public String raza;
	
	public Lobo(String nombre,String tipo){
		this.nombre=nombre;
		raza=tipo;
	}
	
	public void haceRuido(){
		System.out.println("El lobo "+nombre+" aulla");
	}
	
	public void comer(){
		System.out.println("El lobo come");
	}
}
