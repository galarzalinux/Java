/**
 * @(#)Pi.java
 *
 *
 * @author José Arturo Medina Galarza
 */
import java.util.Scanner;

public class Pi {

	static Scanner scan=new Scanner(System.in);

	static public double funcion(double x){
		return Math.sqrt(1 - Math.pow(x, 2));
	}

	static public double funcionSumatoria(){
		double i,x,n,res=0;
		System.out.println("Teclea los intervalos");
		n=scan.nextDouble();
		scan.reset();
		for(i=0;i<n;i++){
			x=((Math.pow(-1,i))/((2*i)+1));
			res=res+x;
		}
		return res=res*4;
	}

	static public double funcionSimpson(){
		final int a=0;
		final int b=1;
		double res=0,h,parcial=0;
		double parte[]=new double[4];
		System.out.println("Teclea el incremento");
		h=scan.nextDouble();
		h=1/h;
		scan.reset();
		/*	parte[0]=Pi.funcion(a);
    	parte[1]=(3*Pi.funcion(1/3));
    	parte[2]=(3*Pi.funcion(2/3));
    	parte[3]=Pi.funcion(b);	*/
		parte[0]=Pi.funcion(a);
		parte[1]=(3*Math.pow(8/9,2));
		parte[2]=(3*Math.pow(5/9,2));
		parte[3]=Pi.funcion(b);
		for(int i=0;i<4;i++){
			parcial=parcial+parte[i];
			System.out.println(""+parte[i]+"||"+parcial);
		}
		res=(((3*h)/8)*parcial);
		res=res*4;

		/*
		int a,b,c;
		a=1;b=-5;c=6;
		double discriminant = Math.sqrt((b*b) - (4*a*c));
		System.out.println("Discriminant="+discriminant);
		double root1 = (-b + discriminant)/(4*a);
		double root2 = (-b - discriminant)/(4*a);
		System.out.println("Root1="+root1+" Root2="+root2);
		 */
		return res;
	}

	static public double funcionTrapecios(){
		final int a=0;
		final int b=1;
		int i;
		double res=0,h,parcial=Pi.funcion(a),delta;
		System.out.println("Teclea el incremento");
		delta=scan.nextDouble();
		scan.reset();
		h=1/delta;
		for(i=0;i<delta;i++){
			parcial+=2*Pi.funcion(h * (i + 1));
		}
		res=parcial+Pi.funcion(b);
		res=res*(h/2);
		return res*4;
	}

	public static void main(String[] args) {
		double res=0;
		int op;
		boolean ban=true;
		do{
			System.out.println("Por que metodo deseas calcular Pi=3.14159265358979323846...");
			System.out.println("1.-Por Sumatoria");
			System.out.println("2.-Por Simpson 3/8");
			System.out.println("3.-Por Trapecios");
			System.out.println("4.-Salir");
			op=scan.nextInt();
			scan.reset();
			switch(op){
				case 1:res=Pi.funcionSumatoria();
				System.out.println("Resultado="+res+"\n");
				break;
				case 2:res=Pi.funcionSimpson();
				System.out.println("Resultado="+res+"\n");
				break;
				case 3:res=Pi.funcionTrapecios();
				System.out.println("Resultado="+res+"\n");
				break;
				case 4:ban=false;
				break;
				default: System.out.println("Opcion equivocada");
				break;

			}
			//System.out.println("");
		}while(ban);
	}
}
