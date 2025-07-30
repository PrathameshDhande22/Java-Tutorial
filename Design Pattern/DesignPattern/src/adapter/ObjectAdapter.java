package adapter;

/**
 * Duck actual implementation
 */
interface Duck {
	public void fly();

	public void quack();
}

/**
 * Implementations of the MallardDuck using the Duck Interface.
 */
class MallardDuck implements Duck {

	@Override
	public void fly() {
		System.out.println("Mallard Duck Flying");
	}

	@Override
	public void quack() {
		System.out.println("Mallard Duck quacking");
	}

}

/**
 * Turkey Interface which is our adapter class need to work with the Duck
 * Interface.
 */
interface Turkey {
	public void fly();

	public void run();
}

/**
 * WildTurkey which is able to fly and run but we want to make it work using
 * Duck Class because it belongs too Ducks Category.
 */
class WildTurkey implements Turkey {

	@Override
	public void fly() {
		System.out.println("Turkey Flying");
	}

	@Override
	public void run() {
		System.out.println("Turkey Running");
	}

}

/**
 * TurkeyAdapter Class which converts The Turkey to adapt the Duck.
 */
class TurkeyAdapter implements Duck {
	private Turkey turkey;

	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void fly() {
		this.turkey.fly();
	}

	@Override
	public void quack() {
		this.turkey.run();
	}
}

public class ObjectAdapter {
	public static void main(String[] args) {
		// Here we created the object of the original Duck
		Duck duck = new MallardDuck();
		// Here we are called the Turkey while converting it to the Duck class
		Duck duck2 = new TurkeyAdapter(new WildTurkey());
		
		duck.quack();
		duck2.quack();
		
	}
}

/**
Mallard Duck quacking
Turkey Running
*/