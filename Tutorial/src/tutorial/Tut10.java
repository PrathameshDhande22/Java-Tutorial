package tutorial;

//Methods in java
public class Tut10 {
	// static method
	public static double sum(int x, int y) {
		return x + y;
	}

	// simple method
	public boolean ifequal(String a, String b) {
		return a.equalsIgnoreCase(b);
	}

	public static void main(String[] args) {
		System.out.println(sum(2, 3));
		// the above method was static method so it was directly
		// to call the simple method we need to create the object of the Class
		Tut10 obj = new Tut10();
		System.out.println(obj.ifequal("Prath", "Prath"));
		System.out.println(obj.ifequal("Prath", "Dhande"));
	}

}
