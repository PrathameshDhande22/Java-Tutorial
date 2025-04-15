package abstractfactory;

// Base class for creating a Pizza
abstract class Pizza {
	public String name;
	public String dough;
	public String sauce;

	// Prepares the pizza by printing the preparation message
	public void prepare() {
		System.out.println(this.name + " is being prepared.");
	}

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

// Base class for Pizza Store
abstract class PizzaStore {

	// Processes the order by creating the pizza and performing the standard steps
	public void orderPizza(String type) {
		Pizza pizza = createPizza(type);
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
	abstract public Pizza createPizza(String type);
}

// New York Style Pizzas

// New York Style Cheese Pizza
class NyStyleCheesePizza extends Pizza {
	public NyStyleCheesePizza() {
		this.name = "NY Style Cheese Pizza";
		this.dough = "NY Style Dough";
		this.sauce = "NY Style Sauce";
	}
}

// New York Style Mayonnaise Pizza
class NyStyleMayoPizza extends Pizza {
	public NyStyleMayoPizza() {
		this.name = "NY Style Mayonnaise Pizza";
		this.dough = "NY Style Dough for Mayonnaise Pizza";
		this.sauce = "NY Style Sauce for Pizza";
	}
}

// Chicago Style Pizzas

// Chicago Style Schezwan Pizza
class ChicagostyleSchezwanPizza extends Pizza {
	public ChicagostyleSchezwanPizza() {
		this.name = "Chicago Style Schezwan Pizza";
		this.dough = "Chicago Dough";
		this.sauce = "Chicago Sauce";
	}
}

// Chicago Style Paneer Pizza
class ChicagoStylePaneerPizza extends Pizza {
	public ChicagoStylePaneerPizza() {
		this.name = "Chicago Paneer Pizza";
		this.dough = "Chicago Special Paneer Dough";
		this.sauce = "Chicago Homemade Sauce";
	}
}

// Pizza store for New York style pizzas.
class NyPizzaStore extends PizzaStore {
	@Override
	public Pizza createPizza(String type) {
		if (type.equalsIgnoreCase("cheese")) {
			return new NyStyleCheesePizza();
		} else if (type.equalsIgnoreCase("mayonnaise")) {
			return new NyStyleMayoPizza();
		}
		return null;
	}
}

// Pizza store for Chicago style pizzas.
class ChicagoPizzaStore extends PizzaStore {
	@Override
	public Pizza createPizza(String type) {
		if (type.equalsIgnoreCase("schezwan")) {
			return new ChicagostyleSchezwanPizza();
		} else if (type.equalsIgnoreCase("paneer")) {
			return new ChicagoStylePaneerPizza();
		}
		return null;
	}
}

public class FactoryMethod {

	public static void main(String[] args) {

		// Ordering the cheese pizza from the New York Pizza Store
		PizzaStore nyPizzaStore = new NyPizzaStore();
		// The store creates and processes the order for a cheese pizza.
		nyPizzaStore.orderPizza("cheese");

		// Ordering the paneer pizza from the Chicago Pizza Store
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		chicagoStore.orderPizza("paneer");
	}
}

/***
 * Expected Output: 
 * NY Style Cheese Pizza is being prepared. 
 * Pizza is baking.
 * Pizza has been cut. 
 * Pizza is boxed and ready for delivery. 
 * Chicago Paneer
 * Pizza is being prepared. 
 * Pizza is baking. 
 * Pizza has been cut. 
 * Pizza is boxed and ready for delivery.
 ***/
