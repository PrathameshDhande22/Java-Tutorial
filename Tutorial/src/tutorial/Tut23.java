package tutorial;

//Interface
interface Mobile {
	public int Camera();

	default void Location() {
		System.out.println("Boisar");
	}
}

//inheritance in interface
interface Glass extends Mobile {
	public void glassQuality();

	public int Camera();
}

// polymorphism in interface
interface A {
	public void amethod();
}

interface B {
	public void bmethod();
}

interface C {
	public void cmethod();
}

class polyinterface implements A, B, C {

	@Override
	public void cmethod() {
		System.out.println("C method called");
	}

	@Override
	public void bmethod() {
		System.out.println("B method Called");
	}

	@Override
	public void amethod() {
		System.out.println("A Method Called");
	}

	public void priting() {
		// polymorphism
		A a = new polyinterface();
		a.amethod();
		B b = new polyinterface();
		b.bmethod();
		bmethod();
	}

}

public class Tut23 implements Glass {

	public static void main(String[] args) {
		Tut23 tt = new Tut23();
		System.out.println(tt.Camera());
		tt.Location();
		tt.glassQuality();
		polyinterface pt = new polyinterface();
		pt.priting();
		Glass b = new Tut23();
		System.out.println(b.Camera());
		b.Location();
		Mobile a = new Tut23();
		System.out.println(a.Camera());
		a.Location();
	}

	@Override
	public int Camera() {
		return 45;
	}

	@Override
	public void glassQuality() {
		System.out.println("Better");
	}

}
