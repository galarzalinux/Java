package Animal.Main;
import Animal.Animal;
import Animal.Mamifero.*;

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
		/*
		Perro p=new Perro("Eli","Corriente");
		p.haceRuido();
		Animal a=new Perro("Eli","Corriente");
		a.haceRuido();
		a.comer();
		Animal an=new Animal();
		an.comer();
		Lobo l =new Lobo("","");
		comiendo(a);
		comiendo(l);
		Animal g=new Gato("","");
		g.haceRuido();
		*/
		Animal[] mascota=new Animal[3];
		mascota[0]=new Perro("","");
		mascota[1]=new Lobo("","");
		mascota[2]=new Gato("","");
		for (Animal animal : mascota) {
	          //  animal.comer();
	            comiendo(animal);
	            animal.haceRuido();
            }
	}

}
