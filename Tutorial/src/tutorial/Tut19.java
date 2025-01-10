package tutorial;

//Inheritance this is single inheritance
class College {
	public College() {
		System.out.println("College Constructor with empty");
	}

	public College(int x) {
		System.out.println("College Constructor with value of x : " + x);
	}

	public void Supercalledmethod() {
		System.out.println("This method has been called with the help of super");
	}
}

//single inheritance
class Student3 extends College {
	public Student3() {
		super.Supercalledmethod(); // calling the college class method
		System.out.println("Student Constructor with empty");

	}

	public Student3(int x) {
		super(x); // calling the constructor of college class with x parameter
		System.out.println("Student Constructor with value of x :" + x);

	}
}

// this is multilevel inheritance
class Faculty extends Student3 {

}

//hierarchial inheritance
class details extends College {

}

class teacher extends College {

}

public class Tut19 {

	public static void main(String[] args) {
		Student3 st = new Student3();
		st.Supercalledmethod();
	}

}
