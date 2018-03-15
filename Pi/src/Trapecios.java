/*
 * Ing. José Arturo Medina Galarza
 */

public class Trapecios implements Runnable{
	private double delta,total=0;
	private int inicio;
	private double[] reshilo=new double[2];

	public double funcion(double x){
		return Math.sqrt(1 - Math.pow(x, 2));
	}

	public double metodoTrapecios(){
		final int a=0;
		final int b=1;
		int i;
		double h=0,res=0,parcial=0;
		h=1/delta;
		for(i=0;i<delta;i++){
			parcial+=2*funcion(h * (i + 1));
		}
		res=parcial+funcion(b)+funcion(a);
		res=res*(h/2);
		return res*4;
	}

	public  Trapecios(double incremento,int ini) {
		delta=incremento;
		inicio=ini;
	}

	public void run() {
		final int a=0;
		final int b=1;
		int i;
		double h=0.0;
		
		h=1/delta;
		for(i=inicio;i<delta;i=i+2){
			reshilo[inicio]+=2*this.funcion(h * (i + 1));
		}
		total=reshilo[0]+reshilo[1];
		total=(h/2)*(this.funcion(a)+total+this.funcion(b));
	}
}
