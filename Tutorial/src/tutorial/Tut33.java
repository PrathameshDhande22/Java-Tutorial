package tutorial;

//lambda Expresssion

interface Animal_Sounds {
	public void Dog();

	public void Cat(String sound);
}

@FunctionalInterface
interface Buffalo {
	public void Sound();
}

@FunctionalInterface
interface Cow {
	public void Cowsound(String sound);
}

public class Tut33 {

	public static void main(String[] args) {
		// you can implements this interface either implementing with or class or
		// creating the annoymous class
		Animal_Sounds an = new Animal_Sounds() {

			@Override
			public void Dog() {
				System.out.println("Bow Bow");
			}

			@Override
			public void Cat(String sound) {
				System.out.println(sound);
			}
		};

		// calling the interface function
		an.Cat("Meow Meow");
		an.Dog();
		anothermethod();
		anotherlamba();
	}

	// lambda expression works with only functional interface
	// lambda expression without parameter
	public static void anothermethod() {
		Buffalo an = () -> {
			System.out.println("Moww Moww");
		};
		an.Sound();
	}

	// lambda expression with one parameter
	public static void anotherlamba() {
		Cow c = (sound) -> {
			System.out.println(sound);
		};
		c.Cowsound("Mowwwwwww chotta");
	}

}
