package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Creating the MenuItem Class
class MenuItem {
    private String Name;
    private String Description;
    private int Price;

    public MenuItem(String Name, String Description, int Price) {
        this.Description = Description;
        this.Price = Price;
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getName() {
        return Name;
    }

    public int getPrice() {
        return Price;
    }
}

// Creating the Interface for Menu which will return the iterator
interface Menu {
    public Iterator<MenuItem> createIterator();
}

// Creating the Menus where it depends on the ArrayList
// It has the ArrayList as Implementation.
class DinnerMenu implements Menu {
    private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

    public DinnerMenu() {
        addItem("Paneer Masala", "Curry Paneer Masala", 123);
        addItem("Butter Paneer Masala", "Tadka butter Paneer Masala", 134);
        addItem("Tawa Paneer Masala", "Delicious Paneer in the Tawa", 178);
    }

    @Override
    public String toString() {
        return "DinnerMenu";
    }

    // Returning the Java Inbuilt iterator.
    @Override
    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }

    public void addItem(String name, String description, int price) {
        MenuItem menuItem = new MenuItem(name, description, price);
        this.menuItems.add(menuItem);
    }
}

//Creating the another menu which implements the array so for it we need to create our custom iterator
class DessertMenu implements Menu {
    private final int SIZE = 3;
    private int numberofItem = 0;
    private MenuItem[] items = new MenuItem[SIZE];

    @Override
    public String toString() {
        return "DessertMenu";
    }

    public DessertMenu() {
        addItem("Gulab Jamun", "Sweet and Juicy ", 89);
        addItem("Rasmalai", "Pure Milk Rasmalai", 350);
        addItem("Rabdi", "Pure and Fresh Milk Rabdi", 230);
    }

    public void addItem(String name, String description, int price) {
        MenuItem menuItem = new MenuItem(name, description, price);
        if (numberofItem < SIZE) {
            items[numberofItem++] = menuItem;
        } else {
            System.err.println("Number of Items Reached");
        }
    }

    //  For creating the Iterator for array we need to implement the custom iterator and using that iterator
    @Override
    public Iterator<MenuItem> createIterator() {
        return new DessertMenuIterator(this.items);
    }
}

// Creating our custom iterator using the java Iterator
class DessertMenuIterator implements Iterator<MenuItem> {
    private MenuItem[] items;
    private int position = 0;

    public DessertMenuIterator(MenuItem[] menuItems) {
        this.items = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < items.length;
    }

    @Override
    public MenuItem next() {
        return this.items[position++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("these method is not implemented");
    }
}

// Implementing the Waitress Code
class Waitress {
    private List<Menu> menus;

    public Waitress(List<Menu> menu) {
        this.menus = menu;
    }

    public void printMenu() {
        for (Menu currentmenu : menus) {
            System.out.println("\n"+currentmenu + " == ");
            printMenu(currentmenu.createIterator());
        }
    }

    //    Printing all the Menu items present in the Menus using iterator
    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " --- ");
            System.out.println(menuItem.getDescription());
        }
    }
}


public class IteratorPattern {
    public static void main(String[] args) {
        // Initiating the menu classes
        Menu desertMenu = new DessertMenu();
        Menu dinnerMenu = new DinnerMenu();

        // using the Waitress
        Waitress waitress = new Waitress(new ArrayList<>() {
            {
                add(desertMenu);
                add(dinnerMenu);
            }
        });

        waitress.printMenu();
    }
}
