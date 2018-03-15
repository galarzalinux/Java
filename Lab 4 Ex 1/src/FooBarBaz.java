//Activity Guide  Lab 4  Ex 1
public class FooBarBaz {

	public static void main(String[] args) {
		String[] cadena={"foo","bar","baz"};

		for (int i = 1; i <= 50; i++) {
			System.out.print(""+i);
			if(i%3==0){
				System.out.print(" "+cadena[0]);
			}
			if(i%5==0){
				System.out.print(" "+cadena[1]);
			}
			if(i%7==0){
				System.out.print(" "+cadena[2]);
			}
			System.out.println();
		}
	}

}
