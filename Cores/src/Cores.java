/*
 * Ing. José A. Galarza
 *  
 */

public class Cores implements Runnable{

    public final static long MAXITERATIONS=(long) Math.pow(2,25);
    private byte corenumber;
    private long tinicial0,tfinal0,tinicial1,tfinal1,tinicial2,tfinal2,tinicial3,tfinal3;
    public long res1=0L,res3=0L;
    public long i,j,k,l;

    public Cores(byte corenumber) {
        this.corenumber=corenumber;
    }
    
    public static void main(String[] args) {
             
	    Cores testcore0=new Cores((byte)0);
	    Cores testcore1=new Cores((byte)1);
	    Cores testcore2=new Cores((byte)2);
	    Cores testcore3=new Cores((byte)3);
        
        Thread hilocoregalarza0=new Thread(testcore0);
        Thread hilocoregalarza1=new Thread(testcore1);
        Thread hilocoregalarza2=new Thread(testcore2);
        Thread hilocoregalarza3=new Thread(testcore3);
        
        hilocoregalarza0.start();
        hilocoregalarza1.start();
        hilocoregalarza2.start();
        hilocoregalarza3.start();
    }

    public void run(){
        switch (corenumber) {
            case 0://Punto Flotante 1
                tinicial0=System.nanoTime();
                for(i=0L;i<MAXITERATIONS;i++){
                    Math.tan(Math.atan(Math.acos(Math.cos(Math.PI))));
                }
                tfinal0=System.nanoTime();
                System.out.println("Tiempo Core0: "+((tfinal0-tinicial0)/1000000000.0)+" seg");
                break;
            case 1://Prueba Enteros 1
                tinicial1=System.nanoTime();
                for(j=1L;j<=MAXITERATIONS;j++){
                    res1=(j*j/j)-j;
                }
                tfinal1=System.nanoTime();
                System.out.println("Tiempo Core1: "+((tfinal1-tinicial1)/1000000000.0)+" seg");
                break;
            case 2://Punto Flotante 2
                tinicial2=System.nanoTime();
                for(k=0L;k<MAXITERATIONS;k++){
                    Math.pow(10, Math.log10(Math.pow(Math.E,Math.log(Math.PI))));
                }
                tfinal2=System.nanoTime();
                System.out.println("Tiempo Core2: "+((tfinal2-tinicial2)/1000000000.0)+" seg");
                break;
            case 3://Prueba Enteros 2
                tinicial3=System.nanoTime();
                for(l=1;l<=MAXITERATIONS;l++){
            	    res3=l*l;
                      res3=((l)-(res3-1/l+1)-(l-1));
                }
                tfinal3=System.nanoTime();
                System.out.println("Tiempo Core3: "+((tfinal3-tinicial3)/1000000000.0)+" seg");
                break;
        }
    }
}
