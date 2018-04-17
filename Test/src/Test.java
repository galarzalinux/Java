/*
public class Test {

	 static int maxDifference(int[] a) {
	        int max=0,min=0,pos=0,i,j;
	        //Finds Max number
	        for(i=0;i<a.length;i++){
	            if(a[i]>max){
	                max=a[i];
	                pos=i;
	            }
	            min=max;
	        }
	        //Finds Min number before Max number
	        for(j=0;j<pos;j++){
	      	  System.out.println("a::"+a[j]);
	            if(a[j]<min){
	                min=a[j];
	                System.out.println("m"+min+" a"+a[j]);
	            }
	        }
	        return max-min;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[5];
		a[0]=2;
		a[1]=5;
		a[2]=4;
		a[3]=8;
		a[4]=1;
		System.out.println("res "+maxDifference(a)); 

	}

}
 */

import java.util.*;

public class Test {	
/*
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String temp="";
		temp=Integer.toBinaryString(n);
		System.out.println(temp);
		byte[] barray=new byte[temp.length()];
		barray=temp.getBytes();
		int i=0,max=0,min=0;
		while(i<temp.length()){
			if(barray[i]!=48){
				min++;                
			}else{
				min=0;
			}
			if(min>max){
				max=min;
			}
			i++;
		}
		System.out.println(""+max);
		in.close();
	}
	*/
	
	static String s1="qwer";
	static String s2;
	static String s3=s1;
	
	public static int hashCode1() {
		int res=0;
		int i,len=s2.length();
		byte[] array=s2.getBytes();
		for (i = 0; i < len; i++) {
			res+=(int)array[i]*(Math.pow(31.0, (len-1.0-i)));
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		Scanner scanf=new Scanner(System.in);
		s2=scanf.nextLine();
		scanf.reset();
		System.out.println("String 1: "+s1+"\nString 2: "+s2);
		System.out.println("Hash1: "+s1.hashCode()+"\nHash2: "+hashCode1());
		System.out.println("equals: "+s1.equals(s2));
		System.out.println("==: "+(s1==s2));
		System.out.println("==: "+(s1==s3));
		scanf.close();
	}
	
}
