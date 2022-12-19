package tutorial;

//inner class and outer class
class Outer {
	public int a;
	public int b;

	public Outer(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void Outermethod() {
		System.out.println("Called the Outer class" + this.a);
	}

	class Inner {
		public int c;
		public int d;

		public Inner(int c, int d) {
			this.c = c;
			this.d = d;
		}

		public void Innermethod() {
			System.out.println("Called the Inner class" + this.c);
		}
	}
}

public class Tut37 {

	public static void main(String[] args) {
		// Outer class calling
		Outer c = new Outer(1, 2);
		c.Outermethod();
		Outer.Inner inn = c.new Inner(3, 2);
		System.out.println(inn.c);
		inn.Innermethod();
	}

}
