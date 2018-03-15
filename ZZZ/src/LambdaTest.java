import java.util.Arrays;
import java.util.List;

interface A{
	void show();
}

class XYZ implements A{

	@Override
	public void show() {
		System.out.println("Hello");
	}
}

@FunctionalInterface
interface CitrusFruits{
	int  totalCitrusFruits (int lemonCount, int orangeCount);
}

public class LambdaTest {

	public static void main(String[] args) {
		double init=QueryPerformance.timeCounter();		
		A obj;
		obj=new A() {
			public void show() {
				System.out.println("Hola");
			}
		};
		
		obj=() -> System.out.println("Hola");
		obj.show();
		
		CitrusFruits cit=(lemonCount,orangeCount)->(lemonCount+orangeCount);
		System.out.println(cit.totalCitrusFruits(12, 20));
		
		
		List<String> fruits=Arrays.asList("Apple", "grapes", "Orange", "mango");

		fruits.forEach(n -> System.out.println(n)); 		
		System.out.println(QueryPerformance.counterNano(init));
	}
}
