package Strategy;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("MUte Quacking");
	}
}
