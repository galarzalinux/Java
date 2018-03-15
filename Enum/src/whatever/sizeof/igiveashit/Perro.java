package whatever.sizeof.igiveashit;

public class Perro {
	
	public enum Razas {
		PASTORALEMAN("Pastor Aleman"), 
		DOBERMAN("Doberman"), 
		PUG("Pug"), 
		BOXER("Boxer");

		String razaEnum;

		private Razas(String raz){
			this.razaEnum=raz;
		}

		public String getTipo(){
			return razaEnum;
		}
		
		public String getNombre(String nom){
			return("Mi pero "+razaEnum+" su nombre es "+nom+"");
		}
		
	}
	
	public Razas raza;

	public Perro(Razas raza) {
		this.raza = raza;
	}
	public Perro() {
	      
      }

	public void whatever(Razas perro) {
		switch (perro) {
			case PASTORALEMAN:
				System.out.println("El perro es un Pastor Aleman");
				break;
			case DOBERMAN:
				System.out.println("El perro es un Doberman");
				break;
			case PUG:
				System.out.println("El perro es un Pug");
				break;
			case BOXER:
				System.out.println("El perro es un Boxer");
				break;
		}
	}
/*
	public static void main(String[] args) {
		Perro p = new Perro(Razas.PUG);
		System.out.println(p.raza.getTipo());
		System.out.println(Razas.BOXER.getTipo());
		p.whatever(p.raza);

	}
	*/
}
