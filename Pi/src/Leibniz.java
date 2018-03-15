/*
 * Ing. José Arturo Medina Galarza
 */

public class Leibniz implements Runnable{
	private double delta;
	private int inicio;
	private double[] reshilo=new double[2];
	
	public double metodoLeibniz(){
		int i;
		double res=0,temp=0;
		for(i=0;i<delta;i++){
			temp=((Math.pow(-1,i))/((2*i)+1));
			res+=temp;
		}
		return res*4;
	}
	
	public Leibniz(double incremento,int ini) {
		delta=incremento;
		inicio=ini;
	}

      public void run() {
      	int i;
      	double temp=0;
		for(i=inicio;i<delta;i=i+2){
			temp=(Math.pow(-1,i))/((2*i)+1);
			reshilo[inicio]+=temp;
			
		}
      }
}
