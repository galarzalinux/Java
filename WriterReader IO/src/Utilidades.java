import java.util.Scanner;

public final class Utilidades {
	
	static Scanner scan=new Scanner(System.in);
	
	public static byte[] intToByte(int a) {//Convierte un int a cadena de bytes.
		byte[] bytearray = new byte[4];
		int i;
		for(i=0;i<4;i++)
			bytearray[i]=(byte)(a>>(i*8));
		return bytearray;
	}

	public static byte[] longToByte(long a) {//Convierte un long a cadena de bytes.
		byte[] bytearray = new byte[8];
		int i;
		for(i=0;i<8;i++)
			bytearray[i]=(byte)(a>>(i*8));
		return bytearray;
	} 
	
	//Recibe una cadena de bytes, la posicion inicial y la cantidad de bytes a recorrer en el arreglo
	//y regresa un valor entero
	public static int byteToInt(byte[] bytearray,int posini,int cantidadbytes){
		int resultado=0,i,j=0;
		cantidadbytes=cantidadbytes+posini;
		for(i=posini;i<cantidadbytes;i++){
			resultado+=(bytearray[i]<<(j*8));
			j++;
		}
		return resultado;
	}
}
