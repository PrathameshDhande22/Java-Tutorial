package tutorial;

//OOPs - Object Oriented Programming

//creating class
class Employee{
	int id;
	String name;
}

public class Tut14 {

	public static void main(String[] args) {
		Employee em=new Employee(); //creating the object of employee
		em.id=1;
		em.name="Prathamesh dhande";
		System.out.println("ID :"+em.id+"\nName :"+em.name);
	}

}
