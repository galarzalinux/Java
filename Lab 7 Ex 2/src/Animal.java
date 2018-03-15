//Activity Guide  Lab 7 Ex 2
public abstract class Animal {

	private int legs;
	
	protected Animal(int legs) {
		this.legs=legs;
	}
	
	public abstract void eat();
	
	public void walk(){
		System.out.println("The animal walks on "+legs+" legs");
	}

}
