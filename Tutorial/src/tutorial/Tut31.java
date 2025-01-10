package tutorial;

//final keyword

//final class cannot be inherited from other class
final class First {
	public void display() {
		System.out.println("Final Class");
	}
}

public class Tut31 {

	public static void main(String[] args) {
		final int no = 10;
		System.out.println(no);
//		no=1; You cannot change the final variable
		display();
	}

	// you cannot override this method bcoz of final keyword
	public final static void display() {
		System.out.println("This is final method");
	}

}
