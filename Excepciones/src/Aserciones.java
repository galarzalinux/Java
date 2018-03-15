import java.util.Scanner;

public class Aserciones {

	public Aserciones() {
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cadena;
		System.out.println("Teclea un entero");
		cadena=sc.nextInt();
		assert cadena>2:"Dah";
		System.out.println("Tecleaste "+cadena);
		sc.close();
	}

}
