public class Lambdas_01_04 {

	public static void main(String[] args) {
		//example of passing multiple values to a method using lambda 
		//notice that I do NOT have to specify the data type of a and b
		
		Calculate add =(a,b)-> a + b;
		Calculate difference = (a,b) -> Math.abs(a-b);
		Calculate divide =(a,b)-> (b != 0 ? a/b : 0);
		Calculate multiply=(a,b)->Math.multiplyExact(a, b);

		System.out.println(add.calc(3,2));
		System.out.println(difference.calc(5,10));
		System.out.println(divide.calc(15, 3));
		System.out.println(multiply.calc(5, 5));
		
		Calculate mod=new Calculate() {
			@Override
			public int calc(int x, int y) {
				return x%y;
			}
		};

		System.out.println(mod.calc(10, 3));
	}

	@FunctionalInterface
	public interface Calculate {
		int calc(int x, int y); 
	}
}