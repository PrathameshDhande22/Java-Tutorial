package tutorial;

//constructor in java

class StudentRecord {
	private int rollno;
	private String name;
	private int std;

	// creating the constructor
	public StudentRecord(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}

	// constructor overloading
	public StudentRecord(int rollno, String name, int std) {
		this.rollno = rollno;
		this.name = name;
		this.std = std;
	}

	// getter and setter
	public int getRollno() {
		return rollno;
	}

	public String getName() {
		return name;
	}

	public int getStd() {
		return std;
	}

}

public class Tut17 {

	public static void main(String[] args) {
		StudentRecord st = new StudentRecord(1, "Prathamesh");
		System.out.println("Rollno : " + st.getRollno() + "\nName : " + st.getName() + "\nSTD : " + st.getStd());
		StudentRecord st2 = new StudentRecord(2, "Sushant", 7);
		System.out.println("Rollno : " + st2.getRollno() + "\nName : " + st2.getName() + "\nSTD : " + st2.getStd());
	}

}
