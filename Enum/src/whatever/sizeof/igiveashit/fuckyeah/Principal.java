package whatever.sizeof.igiveashit.fuckyeah;
import whatever.sizeof.igiveashit.*;
import static whatever.sizeof.igiveashit.Perro.Razas.*;

public class Principal {

	public static void main(String[] args) {
		Perro p = new Perro(PUG);
		//System.out.println(p.raza.getTipo());
		//System.out.println(Razas.BOXER.getTipo());
		p.whatever(p.raza);
		System.out.println(PUG.getNombre("Chicloforito"));
	}

}
