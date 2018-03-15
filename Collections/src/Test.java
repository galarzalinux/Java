import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		ArrayList<String> chuches1,chuches2;
		chuches1=new ArrayList<>(Arrays.asList("Sabritas","Doritos","Chetos"));
		chuches2=new ArrayList<>(Arrays.asList("Poffets","Churmaiz","Pizzerolas"));
		chuches1.addAll(chuches2);
		System.out.println(chuches1);
		chuches1.add("Ruffles");
		System.out.println(chuches1);
		if(chuches1.contains("Poffets")) {
			chuches1.remove("Poffets");
		}
		System.out.println(chuches1);
	}
}