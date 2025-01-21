package Strategy;

public class Index {
	public static void main(String[] args) {
		// The duck which is mute and cannot fly lets create that duck using rubber duck
		System.out.println("======= Rubber Duck ======");
		Duck duck = new RubberDuck(new NoFly(), new MuteQuack());
		duck.fly();
		duck.quack();

		System.out.println();

		// Mallard Duck
		// Making the code feasible here we can change the behavior any time we want
		// just need to change the constuctor call.
		System.out.println("===== Mallard Duck =====");
		Duck duck2 = new MallardDuck(new FlyWithWings(), new Squeak());
		duck2.fly();
		duck2.quack();
	}
}
