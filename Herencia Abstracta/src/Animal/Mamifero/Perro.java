package Animal.Mamifero;
import Animal.Animal;

public class Perro extends Animal{
	public String raza;
	public String profesion="Policia";
	
	
	
	public Perro(String nombre,String tipo){
		this.nombre=nombre;
		raza=tipo;
	}
	
	public void haceRuido(){
		System.out.println("El perro "+nombre+" ladra");
	}
	
	public void comer(){
		System.out.println("El perro come");
	}
	
	public void comer(String ... s){
		System.out.println("El perro "+nombre+" come Chicloforito!!!!!!!!!!!!!!!!!!!!!!!");
		for (String cadena : s) {
	            System.out.println("El perro come "+cadena);
            }
		
	}
	
	public void comer(String croquetascachorro,int leche){
		System.out.println("El perro "+nombre+" come croquetas marca "+croquetascachorro+
				" y "+leche+" tazas de leche");
	}
	 
	public void comer(String croquetasadulto){
		System.out.println("El perro "+nombre+" come croquetas marca "+croquetasadulto);
	}
	
	public void profesionPerro(){
		System.out.println("El perro es un "+profesion);
	}
	
	public static void main(String[] args) {
	   /*   Perro p=new Perro("","");
	      p.comer("Grande");
	      p.comer("Chico",1);
	      p.comer("Croqutas","Pantuflas","Tarea","Lo que encuentra");	
	      */
      }
	
}
