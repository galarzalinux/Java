/*
 * Ing. José Arturo Medina Galarza
 */

public class Simpson {
	private double delta,total;
	private int inicio;
	private double[] reshilo=new double[2];
	private int[] coeficiente=new int[2]; 
	
	public double funcion(double x){
		return Math.sqrt(1 - Math.pow(x, 2));
	}
	
	public double metodoSimpson(){
		
		return 0;
	}
	
	public Simpson(double incremento,int ini) {
		delta=incremento;
		inicio=ini;
		coeficiente[0]=2;
		coeficiente[1]=4;
	}

}
