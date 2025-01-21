package Strategy;


public class FlyWithWings implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("Can Fly");
	}
}
