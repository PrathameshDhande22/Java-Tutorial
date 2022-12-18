package tutorial;

// access modifier with getter and setter

class Student{
	private int id;
	private String name; //private means only class can access it  
	// for more access modifier see the wiki
	
	public int getid() {
		return id;
	}
	
	public String getname() {
		return name;
	}
	
	public void setid(int id) {
		this.id=id;
	}
	
	public void setname(String name) {
		this.name=name;
	}
}
public class Tut16 {

	public static void main(String[] args) {
		Student st=new Student();
		//note now you cannot access the student class attribute directly you need to use the getter and setter
		st.setid(123);
		st.setname("Prahtamesh");
		System.out.println("ID : "+st.getid()+"\nName : "+st.getname());
	}

}
