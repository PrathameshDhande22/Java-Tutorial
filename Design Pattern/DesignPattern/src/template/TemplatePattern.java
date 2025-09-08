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

// Template Pattern with Hooks
abstract class TemplateWithHook {
	// These is our Algorithm or Say Recipe to Create the Caffine
	public final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (customerAddsCondiments())
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

	// sub class can override the implementation
	public boolean customerAddsCondiments() {
		return true;
	}
}

//Implementation for the algorithm 
class TeaWithHook extends TemplateWithHook {

	@Override
	public void brew() {
		System.out.println("Brewing Tea using Hook");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding Elachi and Malai");
	}

	@Override
	public boolean customerAddsCondiments() {
		return false;
	}
}

//Implementation for the algorithm with different calculation
class CoffeeWithHook extends TemplateWithHook {

	@Override
	public void brew() {
		System.out.println("Brewing Coffee using Hook");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding Extra Sugar and Milk into the Coffee");
	}

	// Overriding the method to add our own implementation
	@Override
	public boolean customerAddsCondiments() {
		return true;
	}

}

public class TemplatePattern {

	public static void main(String[] args) {
		// Calling the Algorithm
		CaffineBeverage mytea = new Tea();
		mytea.prepareRecipe();

		System.out.println();

		CaffineBeverage mycoffee = new Coffee();
		mycoffee.prepareRecipe();

		System.out.println("\nTemplate Pattern with Hook");
		TemplateWithHook teahook = new TeaWithHook();
		teahook.prepareRecipe();

		System.out.println();

		TemplateWithHook coffeehook = new CoffeeWithHook();
		coffeehook.prepareRecipe();
	}

}

/**
 * Output:
Boiling the Water
Brewing Tea
Pouring in the Cup
Adding Elachi and Malai

Boiling the Water
Brewing Coffee
Pouring in the Cup
Adding Extra Sugar and Milk into the Coffee

Template Pattern with Hook
Boiling the Water
Brewing Tea using Hook
Pouring in the Cup

Boiling the Water
Brewing Coffee using Hook
Pouring in the Cup
Adding Extra Sugar and Milk into the Coffee
 */
