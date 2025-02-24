package decorator;

// Coffee.java
/**
 * New recipe of the Coffee class must implement these method.
 */
interface Coffee {
	/**
	 * New Recipe Coffee Description or Say Name
	 * 
	 * @return Description of the Coffee
	 */
	public String getDescription();

	/**
	 * Coffee Cost
	 * 
	 * @return Cost of the Coffee in Rupees.
	 */
	public int getCost();
}

// PlainCoffee.java
class PlainCoffee implements Coffee {

	@Override
	public String getDescription() {
		return "PlainCoffee";
	}

	@Override
	public int getCost() {
		return 10;
	}
}

// CappuccinoCoffee
class CappuccinoCoffee implements Coffee {
	@Override
	public String getDescription() {
		return "Cappuccino";
	}

	@Override
	public int getCost() {
		return 20;
	}
}

// CoffeeDecorator.java
/**
 * Maintains Reference to the Decorated Object
 */
abstract class CoffeeDecorator implements Coffee {
	protected Coffee _coffee;

	public CoffeeDecorator(Coffee coffee) {
		_coffee = coffee;
	}

	@Override
	public String getDescription() {
		return _coffee.getDescription();
	}

	@Override
	public int getCost() {
		return _coffee.getCost();
	}
}

// MilkDecorator.java
class MilkDecorator extends CoffeeDecorator {
	public MilkDecorator(Coffee decoratedcoffee) {
		super(decoratedcoffee);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + " + Milk";
	}

	@Override
	public int getCost() {
		return super.getCost() + 5;
	}
}

// SugarDecorator.java
class SugarDecorator extends CoffeeDecorator {
	public SugarDecorator(Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}

	@Override
	public int getCost() {
		return super.getCost() + 10;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + " + Sugar";
	}
}

public class DecoratorPattern {
	public static void main(String[] args) {
		// Serving only the plain Coffee.
		// Decorator pattern will make sure that only the cost of the plain coffee
		// should be collected
		Coffee plaincoffee = new PlainCoffee();
		System.out.println(plaincoffee.getDescription() + " Cost=" + plaincoffee.getCost());

		// Serving the Capuccinocoffe but user wants extra milk and sugar to it so the
		// cost of adding extra sugar and milk should also be included in the user bill.
		Coffee capuccinocoffee = new CappuccinoCoffee();
		capuccinocoffee = new MilkDecorator(capuccinocoffee);
		capuccinocoffee = new SugarDecorator(capuccinocoffee);
		// here we added the sugar and milk to the cappucinocoffee
		System.out.println(capuccinocoffee.getDescription() + " Cost=" + capuccinocoffee.getCost());

	}
}

/**
 * Output: 
 * PlainCoffee Cost=10 
 * Cappuccino + Milk + Sugar Cost=35
 * 
 */