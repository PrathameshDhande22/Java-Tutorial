package tutorial;

//method overloading
public class Tut11 {

	public void sum(int a) {
		System.out.println(a);
	}

	public void sum(int a, int b) {
		System.out.println(a + b);
	}

	public void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	public static void main(String[] args) {
		Tut11 tt = new Tut11();
		tt.sum(1);
		tt.sum(1, 2);
		tt.sum(1, 1, 3);
	}

}
