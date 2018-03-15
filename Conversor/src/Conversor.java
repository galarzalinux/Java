/*
 * Taller de Sistemas Operativos Avanzados
 * Tarea 2 (Conversor)
 * Medina Galarza José Arturo
 * 303683133
 * 
 */

public class Conversor {

	private long mascara;
	private String cadenabits;
	int contador;

	public String imprimeBits(byte numero){
		mascara=0x01;
		cadenabits="";
		for(contador=0;contador<8;contador++){
			if(contador%8==0){
				cadenabits=" |"+cadenabits;
			}
			if((numero&mascara)!=0){
				cadenabits="1"+cadenabits;
			}
			else{
				cadenabits="0"+cadenabits;                
			}
			mascara=mascara<<1;
		}
		cadenabits="| "+cadenabits;
		return cadenabits;
	}

	public String imprimeBits(short numero){
		mascara=0x01;
		cadenabits="";
		for(contador=0;contador<16;contador++){
			if(contador%8==0){
				cadenabits=" | "+cadenabits;
			}
			if((numero&mascara)!=0){
				cadenabits="1"+cadenabits;
			}
			else{
				cadenabits="0"+cadenabits;                
			}
			mascara=mascara<<1;
		}
		cadenabits="| "+cadenabits;
		return cadenabits;
	}

	public String imprimeBits(int numero){
		mascara=0x01;
		cadenabits="";
		for(contador=0;contador<32;contador++){
			if(contador%8==0){
				cadenabits=" | "+cadenabits;
			}
			if((numero&mascara)!=0){
				cadenabits="1"+cadenabits;
			}
			else{
				cadenabits="0"+cadenabits;                
			}
			mascara=mascara<<1;
		}
		cadenabits="| "+cadenabits;
		return cadenabits;
	}

	public String imprimeBits(long numero){
		mascara=0x01;
		cadenabits="";
		for(contador=0;contador<64;contador++){
			if(contador%8==0){
				cadenabits=" | "+cadenabits;
			}
			if((numero&mascara)!=0){
				cadenabits="1"+cadenabits;
			}
			else{
				cadenabits="0"+cadenabits;                
			}
			mascara=mascara<<1;
		}
		cadenabits="| "+cadenabits;
		return cadenabits;
	}

	public static void main(String[] args) {
		Conversor con;
		con = new Conversor();
		byte i;
		for(i=0;i<16;i++)
			System.out.println(""+con.imprimeBits(i));
		System.out.println(""+con.imprimeBits(0x80));
		System.out.println(""+con.imprimeBits(128));
		System.out.println(""+con.imprimeBits((long)-2147483648));
		System.out.println(""+con.imprimeBits(256));
		System.out.println(""+con.imprimeBits(512));
		System.out.println(""+con.imprimeBits(1024));
		System.out.println(""+con.imprimeBits(-1));
		System.out.println(""+con.imprimeBits(-2));
		System.out.println(""+con.imprimeBits(-127));
		System.out.println(""+con.imprimeBits((short)-128));
		System.out.println(""+con.imprimeBits((long)512));
	}
}