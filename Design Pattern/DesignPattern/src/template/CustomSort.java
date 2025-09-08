package template;

import java.util.ArrayList;
import java.util.Comparator;

// Custom Class/Object
class Duck {
	private int Weight;
	private String Name;

	public int getWeight() {
		return Weight;
	}

	public String getName() {
		return Name;
	}

	public Duck(int weight, String name) {
		this.Name = name;
		this.Weight = weight;
	}
}

// Implementing the Custom Comparator for sorting
class SortDuckByWeight implements Comparator<Duck> {

	@Override
	public int compare(Duck o1, Duck o2) {
		return Integer.compare(o1.getWeight(), o2.getWeight());
	}

}

public class CustomSort {

	public static void main(String[] args) {
		// Create the List of Duck class
		ArrayList<Duck> list = new ArrayList<Duck>();
		addInList(list, 23, "Duck23");
		addInList(list, 12, "Duck12");
		addInList(list, 34, "Duck34");
		System.out.println("Before Sorting");
		printList(list);

		list.sort(new SortDuckByWeight());
		System.out.println("\nAfter Sorting");
		printList(list);

	}

	public static void addInList(ArrayList<Duck> ducks, int weight, String name) {
		ducks.add(new Duck(weight, name));
	}

	public static void printList(ArrayList<Duck> ducks) {
		for (Duck duck : ducks) {
			System.out.println("Ducks\tWeight=" + duck.getWeight() + " Name=" + duck.getName());
		}
	}

}

/**
 * Output: 
Before Sorting
Ducks	Weight=23 Name=Duck23
Ducks	Weight=12 Name=Duck12
Ducks	Weight=34 Name=Duck34

After Sorting
Ducks	Weight=12 Name=Duck12
Ducks	Weight=23 Name=Duck23
Ducks	Weight=34 Name=Duck34

 */
