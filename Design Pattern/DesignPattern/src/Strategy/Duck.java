package Strategy;

public abstract class Duck {

	private FlyBehavior _flyBehavior;
	private QuackBehavior _quackBehavior;

	public Duck(FlyBehavior flybehavior, QuackBehavior quackBehavior) {
		this._flyBehavior = flybehavior;
		this._quackBehavior = quackBehavior;
	}

	public void quack() {
		this._quackBehavior.quack();
	}

	public void fly() {
		this._flyBehavior.fly();
	}
}
