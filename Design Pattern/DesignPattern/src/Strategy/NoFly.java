package Strategy;

public class NoFly implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("Can't Fly");
	}
}
