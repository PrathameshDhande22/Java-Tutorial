package tutorial;

//Generics in java
//creating generics class
class GenExample<T,U>{
	public T o;
	public U s;
	public GenExample(T o,U s) {
		this.o=o;
		this.s=s;
	}
	
	public T getName() {
		return o;
	}
	
	public U getid() {
		return s;
	}
}

public class Tut34 {

	public static void main(String[] args) {
		GenExample<String,String> gn=new GenExample<String, String>("prathamessh", "STJCEM");
		System.out.println(gn.getid());
		System.out.println(gn.getName());
		GenExample<Integer,Integer> gn1=new GenExample<Integer,Integer>(2,3);
		System.out.println(gn1.getid());
		System.out.println(gn1.getName());
		System.out.println(printing("Prathamesh"));
		printing(12323);
	}
	
	//creating generics method
	public static <T> T printing(T name) {
		System.out.println(name.getClass().getName()+" "+name);
		return name;
	}

}
