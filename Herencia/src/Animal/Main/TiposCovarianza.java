package Animal.Main;
import java.util.ArrayList;
import java.util.*;
import Animal.Animal;
import Animal.Mamifero.*;

public class TiposCovarianza {

	public static void metodoA(List<? extends Animal> a){
		for (Animal lista : a) {
			lista.comer();
		}
	}

	public static void main(String[] args) {
		List <Animal> lista=new ArrayList<Animal>();
		List<Perro> listaperro=new ArrayList<Perro>();
		lista.add(new Perro("",""));
		lista.add(new Gato("",""));
		listaperro.add(new Perro("1","1"));
		listaperro.add(new Perro("2","2"));
		metodoA(lista);
		metodoA(listaperro);
	}

}
