package tutorial;

//abstract class
abstract class Abcla {
	abstract public void move();

	abstract public int num(int x);
}

public class Tut22 extends Abcla {

	public static void main(String[] args) {
		Tut22 tt = new Tut22();
		tt.move();
		System.out.println(tt.num(34));
	}

	@Override
	public void move() {
		System.out.println("hello");
	}

	@Override
	public int num(int x) {
		return x;
	}
}
