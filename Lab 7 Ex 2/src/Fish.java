//Activity Guide  Lab 7 Ex 2
public class Fish extends Animal implements Pet {

	public String name;

	public Fish() {
		super(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name=n;
	}


	public void play() {
		System.out.println("Fish swin in their tanks all day.");
	}

	public void eat() {
		System.out.println("Fish eat pond scum.");
	}

	public void walk(){
		super.walk();
		System.out.println("Fish, of course, can't walk; they swim");
	}
}
