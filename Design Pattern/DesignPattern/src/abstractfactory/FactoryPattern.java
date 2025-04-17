package abstractfactory;

// Interface for Creating the Dough
interface Dough {
	public String getName();
}

// Interface for Creating the Sauce based on their regional style
interface Sauce {
	public String getSauce();
}

// Interface for Creating Cheese based on their regional style.
interface Cheese {
	public String getCheese();
}

// Creating the Dough, Sauce and Cheese based on Newyork Style
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

// Creating the Dough, Sauce and Cheese for Chicago Pizza Store
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
		return "PlumtomatoSauce - ChicagoStore";
	}
}

// Creating the Interface for PizzaIngredientFactory
interface PizzaIngredientFactory {
	public Dough createDough();

	public Sauce createSauce();

	public Cheese createCheese();
}

// Creating the PizzaIngredientFactory for NYPizzaStore
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

// Creating the PizzaIngredientFactory for ChicagoPizzaStore
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

abstract class PizzaBase {
	public String name;
	public Dough dough;
	public Sauce sauce;
	public Cheese cheese;

	// Every Pizza Can Create their Own Pizza by using their own Dough, Sauce and
	// Cheese
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

// Creating the Cheese Pizza
class CheesePizza extends PizzaBase {
	// Instance for storing the ingredientfactory
	private PizzaIngredientFactory ingredientfactory;

	public CheesePizza(PizzaIngredientFactory factory) {
		this.ingredientfactory = factory;
		this.name="Cheese Pizza";
	}

	@Override
	public void prepare() {
		System.out.println("Perparing Pizza " + this.name);
		this.cheese = this.ingredientfactory.createCheese();
		this.sauce = this.ingredientfactory.createSauce();
		this.dough = this.ingredientfactory.createDough();
	}
}

// Creating the Schezwan Pizza
class SchezwanPizza extends PizzaBase {
	// Instance for storing the ingredientfactory
	private PizzaIngredientFactory ingredientfactory;

	public SchezwanPizza(PizzaIngredientFactory factory) {
		this.ingredientfactory = factory;
		this.name="SchezwanPizza";
	}

	@Override
	public void prepare() {
		System.out.println("Perparing Pizza " + this.name);
		this.cheese = this.ingredientfactory.createCheese();
		this.sauce = this.ingredientfactory.createSauce();
		this.dough = this.ingredientfactory.createDough();
	}
}

//Base class for Pizza Store
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

// Providing these Pizza into their respective stores with the Ingredient Factory.
class NyPizzaStore1 extends PizzaStore1 {
	private PizzaIngredientFactory ingredientfactory = new NYPizzaIngredientFactory();

	@Override
	protected PizzaBase createPizza(String type) {
		if (type.equalsIgnoreCase("cheese")) {
			return new CheesePizza(ingredientfactory);
		} else if (type.equalsIgnoreCase("schezwan")) {
			return new SchezwanPizza(ingredientfactory);
		}
		return null;
	}
}

// Providing these pizza into their respective Stores with the Ingredient factory
class ChicagoPizzaStore1 extends PizzaStore1 {
	private PizzaIngredientFactory ingredientfactory = new ChicagoPizzaIngredientFactory();

	@Override
	protected PizzaBase createPizza(String type) {
		if (type.equalsIgnoreCase("cheese")) {
			return new CheesePizza(ingredientfactory);
		} else if (type.equalsIgnoreCase("schezwan")) {
			return new SchezwanPizza(ingredientfactory);
		}
		return null;
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		// Ordering the Pizza from the Newyork store
		PizzaStore1 pizzastore = new NyPizzaStore1();
		pizzastore.orderPizza("cheese");

		PizzaStore1 chicagostore = new ChicagoPizzaStore1();
		chicagostore.orderPizza("schezwan");
	}
}
