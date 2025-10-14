package composite;

import java.util.ArrayList;
import java.util.List;

// Implementing the Tree Like Structure for the Employee
// Creating the abstract class such that any leaf or composite can make use of it
abstract class Employee {
    private String name;
    private int Salary;
    private String role;

    public Employee(String name, int Salary, String role) {
        this.name = name;
        this.Salary = Salary;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return Salary;
    }

    // Making the methods as abstract as the implementation can be provided by the inherited class
    public void addEmployee(Employee employee) {
        throw new UnsupportedOperationException("Inherited Class must override");
    }

    public void removeEmployee(Employee employee) {
        throw new UnsupportedOperationException("Inherited Class must override");
    }

    public abstract void displayDetails();
}

// Creating the Developer Employee using the common Employee abstract class as an Leaf
class Developer extends Employee {
    private String name;
    private int salary;
    private String role;

    public Developer(String name, int salary, String role) {
        super(name, salary, role);
    }

    @Override
    public void displayDetails() {
        System.out.println("\tRole: " + getRole() + "\tName: " + getName() + "\tSalary: " + getSalary());
    }
}

// Creating the Composite Class
class Manager extends Employee {
    private String name;
    private int salary;
    private String role;
    private List<Employee> employees = new ArrayList<>();

    public Manager(String name, int salary, String role) {
        super(name, salary, role);
    }

    @Override
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    @Override
    public void displayDetails() {
        System.out.println("Role: " + getRole() + "\tName: " + getName() + "\tSalary: " + getSalary());
        System.out.println("-----------------------------------");
        for (Employee employee : this.employees) {
            employee.displayDetails();
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        // Creating the Tree Like Structure for the composite
        Employee developer1 = new Developer("John Dantle", 15000, "Frontend Developer");
        Employee developer2 = new Developer("Carry Yadav", 20000, "Backend Developer");
        Employee developer3 = new Developer("Sunny wiley", 12000, "SQL");
        Employee developer4 = new Developer("Alice", 30000, "Full Stack Developer");

        // Creating the CEO or root
        Employee ceo = new Manager("Danny", 1300000, "CEO");

        // Creating the two manager
        Employee manager1 = new Manager("Bob Rao", 1000000, "Manager");
        Employee manager2 = new Manager("Frank", 120000, "Manager");

        // Creating the Team Lead
        Employee teamlead1 = new Manager("Franklin", 90000, "Team Lead");
        Employee teamlead2 = new Manager("Rosario", 100000, "Senior Team Lead");

        // Adding the tree or connection between them
        ceo.addEmployee(manager1);
        ceo.addEmployee(manager2);

        manager1.addEmployee(teamlead1);
        manager2.addEmployee(teamlead2);
        manager2.addEmployee(teamlead2);

        teamlead1.addEmployee(developer1);
        teamlead1.addEmployee(developer2);
        teamlead2.addEmployee(developer3);
        teamlead2.addEmployee(developer4);
        teamlead2.addEmployee(developer2);

        System.out.println("--------------- Company Organizational Chart ---------------------\n");
        // printing the tree like structure
        ceo.displayDetails();

    }
}

/// --------------- Company Organizational Chart ---------------------
/// Role: CEO	Name: Danny	Salary: 1300000
/// -----------------------------------
/// Role: Manager	Name: Bob Rao	Salary: 1000000
/// -----------------------------------
/// Role: Team Lead	Name: Franklin	Salary: 90000
/// -----------------------------------
/// Role: Frontend Developer	Name: John Dantle	Salary: 15000
/// Role: Backend Developer	Name: Carry Yadav	Salary: 20000
/// Role: Manager	Name: Frank	Salary: 120000
/// -----------------------------------
/// Role: Senior Team Lead	Name: Rosario	Salary: 100000
/// -----------------------------------
/// Role: SQL	Name: Sunny wiley	Salary: 12000
/// Role: Full Stack Developer	Name: Alice	Salary: 30000
/// Role: Backend Developer	Name: Carry Yadav	Salary: 20000
/// Role: Senior Team Lead	Name: Rosario	Salary: 100000
/// -----------------------------------
/// Role: SQL	Name: Sunny wiley	Salary: 12000
/// Role: Full Stack Developer	Name: Alice	Salary: 30000
/// Role: Backend Developer	Name: Carry Yadav	Salary: 20000
