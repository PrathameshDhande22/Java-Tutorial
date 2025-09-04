package template;

// These is the Algorithm where we know some little bit but its implementation must be provided by the subclasses.
abstract class CaffineBeverage {
	// These is our Algorithm or Say Recipe to Create the Caffine
	public final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	// These steps are common for Coffee and Tea
	public void boilWater() {
		System.out.println("Boiling the Water");
	}

	// Common Steps for Tea and Coffee
	public void pourInCup() {
		System.out.println("Pouring in the Cup");
	}

	// Sub class must provide these for creating the caffine based on what they want
	public abstract void brew();

	// Sub class must provide these for creating the caffine based on what they
	// want.
	public abstract void addCondiments();
}

// Implementation for the algorithm 
class Tea extends CaffineBeverage {

	@Override
	public void brew() {
		System.out.println("Brewing Tea");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding Elachi and Malai");
	}
}

// Implementation for the algorithm with different calculation
class Coffee extends CaffineBeverage {

	@Override
	public void brew() {
		System.out.println("Brewing Coffee");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding Extra Sugar and Milk into the Coffee");
	}

}

public class TemplatePattern {

	public static void main(String[] args) {
		// Calling the Algorithm
		CaffineBeverage mytea = new Tea();
		mytea.prepareRecipe();

		CaffineBeverage mycoffee = new Coffee();
		mycoffee.prepareRecipe();
	}

}
