package abstractfactory;

// Interface for creating Dough
interface Dough {
	public String getName();
}

// Interface for creating Sauce based on regional style
interface Sauce {
	public String getSauce();
}

// Interface for creating Cheese based on regional style
interface Cheese {
	public String getCheese();
}

// Creating Dough, Sauce, and Cheese based on New York style
class ThinCrustDough implements Dough {
	@Override
	public String getName() {
		return "ThinCrustDough - NewYorkStore";
	}
}

class ReggianoCheese implements Cheese {
	@Override
	public String getCheese() {
		return "ReggianoCheese - NewYorkStore";
	}
}

class MarinaraSauce implements Sauce {
	@Override
	public String getSauce() {
		return "MarinaraSauce - NewYorkStore";
	}
}

// Creating Dough, Sauce, and Cheese for the Chicago Pizza Store
class MozzarellaCheese implements Cheese {
	@Override
	public String getCheese() {
		return "MozzarellaCheese - ChicagoStore";
	}
}

class ThickCrustDough implements Dough {
	@Override
	public String getName() {
		return "ThickCrustDough - ChicagoStore";
	}
}

class PlumTomatoSauce implements Sauce {
	@Override
	public String getSauce() {
		return "PlumTomatoSauce - ChicagoStore";
	}
}

// Creating the interface for PizzaIngredientFactory
interface PizzaIngredientFactory {
	public Dough createDough();

	public Sauce createSauce();

	public Cheese createCheese();
}

// PizzaIngredientFactory implementation for NYPizzaStore
class NYPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
}

// PizzaIngredientFactory implementation for ChicagoPizzaStore
class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public Dough createDough() {
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new MozzarellaCheese();
	}
}

// Base class for creating a Pizza
abstract class PizzaBase {
	public String name;
	public Dough dough;
	public Sauce sauce;
	public Cheese cheese;

	// Each Pizza can create its own ingredients using a regional factory
	abstract public void prepare();

	// Bakes the pizza by printing the baking message
	public void bake() {
		System.out.println("Pizza is baking.");
	}

	// Cuts the pizza by printing the cutting message
	public void cut() {
		System.out.println("Pizza has been cut.");
	}

	// Boxes the pizza by printing the boxing message
	public void box() {
		System.out.println("Pizza is boxed and ready for delivery.");
	}
}

// Cheese Pizza class
class CheesePizza extends PizzaBase {
	// Stores the reference to the ingredient factory
	private PizzaIngredientFactory ingredientFactory;

	public CheesePizza(PizzaIngredientFactory factory) {
		this.ingredientFactory = factory;
		this.name = "Cheese Pizza";
	}

	@Override
	public void prepare() {
		System.out.println("Preparing Pizza: " + this.name);
		this.cheese = this.ingredientFactory.createCheese();
		this.sauce = this.ingredientFactory.createSauce();
		this.dough = this.ingredientFactory.createDough();
	}
}

// Schezwan Pizza class
class SchezwanPizza extends PizzaBase {
	// Stores the reference to the ingredient factory
	private PizzaIngredientFactory ingredientFactory;

	public SchezwanPizza(PizzaIngredientFactory factory) {
		this.ingredientFactory = factory;
		this.name = "Schezwan Pizza";
	}

	@Override
	public void prepare() {
		this.cheese = this.ingredientFactory.createCheese();
		this.sauce = this.ingredientFactory.createSauce();
		this.dough = this.ingredientFactory.createDough();
		System.out.println("Preparing Pizza: " + this.name + " " + this.cheese.getCheese());
	}
}

// Base class for Pizza Store
abstract class PizzaStore1 {

	// Processes the order by creating the pizza and performing the standard steps
	public void orderPizza(String type) {
		PizzaBase pizza = createPizza(type);
		if (pizza != null) {
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
		} else {
			System.out.println("Sorry, we do not have that type of pizza.");
		}
	}

	// Abstract method for creating a pizza of a given type
	abstract protected PizzaBase createPizza(String type);
}

// New York Pizza Store using its specific ingredient factory
class NyPizzaStore1 extends PizzaStore1 {
	private PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

	@Override
	protected PizzaBase createPizza(String type) {
		if (type.equalsIgnoreCase("cheese")) {
			return new CheesePizza(ingredientFactory);
		} else if (type.equalsIgnoreCase("schezwan")) {
			return new SchezwanPizza(ingredientFactory);
		}
		return null;
	}
}

// Chicago Pizza Store using its specific ingredient factory
class ChicagoPizzaStore1 extends PizzaStore1 {
	private PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

	@Override
	protected PizzaBase createPizza(String type) {
		if (type.equalsIgnoreCase("cheese")) {
			return new CheesePizza(ingredientFactory);
		} else if (type.equalsIgnoreCase("schezwan")) {
			return new SchezwanPizza(ingredientFactory);
		}
		return null;
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		// Ordering pizza from the New York store
		PizzaStore1 nyStore = new NyPizzaStore1();
		nyStore.orderPizza("cheese");

		// Ordering pizza from the Chicago store
		PizzaStore1 chicagoStore = new ChicagoPizzaStore1();
		chicagoStore.orderPizza("schezwan");
	}
}
