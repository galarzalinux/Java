import java.util.Scanner;

public class Solution {

	public void imprime(String cad){
		byte[] tmp=new byte[64];
		String even="";
		String odd="";
		int i;
		tmp=cad.getBytes();
		for(i=0;i<cad.length();i++){
			if(i%2==0){
				even+=(char)tmp[i];
			}else{
				odd+=(char)tmp[i];
			}
		}
		System.out.println(""+even+" "+odd);
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Solution s=new Solution();
		int numcad,i;
		numcad=scan.nextInt();
		String[] cad=new String[numcad];
		scan.nextLine();
		for(i=0;i<numcad;i++){
			cad[i]=scan.nextLine();
		}
		for(i=0;i<numcad;i++){
			s.imprime(cad[i]);
		} 
	}
}