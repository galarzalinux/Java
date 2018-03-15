//Activity Guide  Lab 5  Ex 1
public class TestArray {


	public static void main(String[] args) {
		int[] array1={2,3,5,7,11,13,17,19};
		int[] array2;
		System.out.print("array 1 is <");
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i]);
			if(i<array1.length-1){
				System.out.print(",");
			}
		}
		System.out.println(">");
		array2=array1;
		for (int j = 0; j < array2.length; j=j+2) {
			array2[j]=j;
		}
		System.out.print("array 1 is <");
		for (int k = 0; k < array2.length; k++) {
			System.out.print(array1[k]);
			if(k<array1.length-1){
				System.out.print(",");
			}
		}
		System.out.println(">");
	}
}
