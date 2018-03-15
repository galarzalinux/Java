
public final class QueryPerformance {
	 
	public static double timeCounter(){
		return System.nanoTime();
	}
		
	public static double counterNano(double init) {
		return (timeCounter()-init)/(Math.pow(10.0, 9.0));
	}
}
