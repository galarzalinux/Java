package Animal.Main;
import Animal.Animal;
import Animal.Mamifero.*;
import Animal.Aves.*;

public class Principal {

	public static void comiendo(Animal p){
		p.comer();
		if(p instanceof Perro){
			((Perro)p).profesionPerro();
			((Perro)p).comer("ChowChow Adulto");
			((Perro)p).comer("ChowChow Cachorro",2);
		}else{
			System.out.println("Este animal no tiene profesion");
		}
	}
	
	public static void main(String[] args) {
		
		Animal[] mascota=new Animal[3];
		mascota[0]=new Perro("Eli","Corriente");
		mascota[1]=new Lobo("Lobito","Desconocida");
		mascota[2]=new Gato("Simbo","Pitera");
		//mascota[3]=new Perico("","");
		for (Animal animal : mascota) {
	          //  animal.comer();
	            comiendo(animal);
	            animal.haceRuido();
            }
		Animal p=new Perico("","");
		p.haceRuido();
		p.comer();
		((Perico) p).despegar();
		((Perico) p).volar();
		((Perico) p).aterrizar();
		
		//Animal peri=new Animal(); //Al declarar un instancia de tipo Animal truena por que no se 
										//puede instanciar un objeto de una clase abstracta
		
	}

}
