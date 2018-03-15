//Activity Guide  Lab 7 Ex 2
public class TestAnimal {

	public static void main(String[] args) {
		Fish f=new Fish();
		Cat c=new Cat("Fluffy");
		Animal a=new Fish();
		Animal s=new Spider();
		Pet p=new Cat();
		
		f.play();
		c.play();
		s.eat();
		s.walk();
		a.walk();
		p.setName("Chicloforito");
		p.play();

	}

}
