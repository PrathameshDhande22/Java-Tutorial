package tutorial;

//Overriding methods
class Animal {
	public void dog() {
		System.out.println("Barks");
	}

	public void anmetod() {
		System.out.println("Animal Method");
	}
}

class Dog extends Animal {
	@Override
	public void dog() {
		System.out.println("Dog is also a Animal");
	}

	public void dogmetho() {
		System.out.println("Dog method is called");
	}
}

public class Tut21 {

	public static void main(String[] args) {
		// overriding method
		Dog dd = new Dog();
		dd.dog();

		// runtime polymorphism also known as dynamic method dispatch
		Animal a = new Dog();
		a.dog();
		a.anmetod();
//		a.dogmethod(); this is not allowed

		Animal a1 = new Animal();
		a1.dog();
		a1.anmetod();
//		Dog ddj=new Animal();  this is not allowed

	}

}
