package tutorial;

//Getter and Setter
class Employee2 {
	public int id;
	public String name;

	// Auto generated from Eclipse ide
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class Tut15 {

	public static void main(String[] args) {
		// creating the object of class Employee
		Employee2 em = new Employee2();
		em.setId(123);
		em.setName("Prathamesh");
		System.out.println("ID : " + em.getId() + "\nName : " + em.getName());
		em.setId(124);
		em.setName("Sushant");
		System.out.println("ID : " + em.getId() + "\nName : " + em.getName());
	}

}
