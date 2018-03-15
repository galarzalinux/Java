//Activity Guide  Lab 7 Ex 2
public class Cat extends Animal implements Pet {

	public String name;

	public Cat(String n) {
		super(4);
		name=n;
	}
	
	public Cat() {
		this("");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String n) {
		name=n;
	}

	public void play() {
		System.out.println(name+" likes to play with string.");
	}

	public void eat() {
		System.out.println("Cats like to eat spiders and mice.");
	}

}
