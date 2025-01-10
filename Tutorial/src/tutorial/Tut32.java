package tutorial;

import java.util.Date;

@FunctionalInterface // this is given when the interface contains only one function
interface ekinterface {
	public void display();
}

//enum and annotations
public class Tut32 {

	@SuppressWarnings({ "deprecation" }) // this will show to suppresswarning
	public static void main(String[] args) {
		Date dt = new Date();
		System.out.println(dt.getMonth()); // getmonth method is deprecated so we will use the annotation suppersswaring
		System.out.println(); // as the method is deprecated so you cannot use it any more
		Accessingenum();
	}

	@Deprecated
	public static void getname1() { // lets notify that this method is deprecated
		System.out.println("prahtma");
	}

	// creation of enum
	public enum Developer {
		Prathamesh, Sushant, Lokesh
	}

	public static void Accessingenum() {
		Developer dl = Developer.Lokesh;
		System.out.println(dl);
		// looping the enum
		for (Developer d : Developer.values()) {
			System.out.println(d);
		}
//		System.out.println(Developer.valueOf(1));
	}
}
