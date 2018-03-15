/*
 * Sample program to introduce functional interfaces with lambda notation
 */

import java.util.function.*;

public class Lambdas_01_01  {

	public static void main(String[] args) {
		//using the test method of Predicate
		//Predicate<Object> nombreFuncion=(Objeto)->validacion.booleana();
		//nombreFuncion.test(Objeto);
		//Lambda Predicate se usa para realizar una validacion booleana 
		Predicate<String> stringLen  = (s)-> s.length() < 10;
		Predicate<Integer>intString=(i)->i.equals(Integer.parseInt("1"));
		System.out.println(stringLen.test("Apples") + " - Apples is less than 10");
		System.out.println(intString.test(1));
		
		//Consumer example uses accept method
		//Consumer<Object> nombreFuncion=(Objeto)->ejecucion.void();
		//nombreFuncion.accept(Objeto);
		//Lambda Consumer se usa  para realizar una funcion VOID 
		Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
		Consumer<Integer>sumGauss=(i)->System.out.println((i*(i+1))/2);
		consumerStr.accept("ABCDefghijklmnopQRSTuvWxyZ");
		sumGauss.accept(100);

		//Function example
		//Function<Objeto1,Objeto2> nombreFuncion=(Objeto1)->ejecucion.return.Objeto2();
		//nombreFuncion.apply(Objeto1);
		//Lambda Function se usa para crear una Funcion que recibe Objeto1 y regresa Objeto2
		Function<Integer,String> converter = (num)-> Integer.toString(num);
		Function<Integer, Double> celTofar=(i)->(i*1.8)+32;
		System.out.println("length of 26: " + converter.apply(26).length());
		System.out.println(celTofar.apply(-40));

		//Supplier example
		//Supplier<Objeto> nombreFuncion=()->return.Objeto();
		//nombreFuncion.apply();
		//Lambda Supplier se usa para regresar Objeto
		Supplier<String> s  = ()-> "Java is fun, ";
		Supplier<Double> d=()->100.0;
		System.out.println(s.get()+d.get()+"%");

		//Binary Operator example
		//BinaryOperator<Objeto> nombreFuncion=(Primitive1,Primitive2)->ejecucion.return.Objeto();
		//nombreFuncion.apply(Primitive1,Primitive2);
		//Lambda BinaryOperator recibe 2 valores primitivos del tipo del Objeto de retorno
		BinaryOperator<Integer> add = (a, b) -> a + b;
		BinaryOperator<String> concatena=(s1,s2)->s1+s2;
		System.out.println("add 10 + 25=" + add.apply(10, 25));
		System.out.println(concatena.apply("Hola ", "Mundo"));

		//Unary Operator example
		//UnaryOperator<Object> nombreFuncion=(Primitive)->ejecucion.return.Objeto();
		//nombreFuncion.apply(Primitive);
		//Lambda UnaryOperator recive un valor primitivo del tipo del Objeto de retorno
		UnaryOperator<String> str  = (msg)-> msg.toUpperCase();
		UnaryOperator<Integer>entero=(i)-> i*=i;
		System.out.println(str.apply("This is my message in upper case"));
		System.out.println(entero.apply(5));
	}
}