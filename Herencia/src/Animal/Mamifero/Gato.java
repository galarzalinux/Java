package Animal.Mamifero;

import Animal.Animal;

public class Gato extends Animal{
	
	public String raza;
	
	public Gato(String nombre,String tipo){
		this.nombre=nombre;
		raza=tipo;
	}
	
	public void haceRuido(){
		System.out.println("El gato ronronea");
	}
	
	public void comer(){
		System.out.println("El gato come");
	}

}
