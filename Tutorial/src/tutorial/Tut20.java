package tutorial;

import java.util.Vector;

//Vector Class
public class Tut20 {

	public static void main(String[] args) {
		// creating instance of vector
		Vector<Integer> vc = new Vector<>();
		vc.add(1);
		vc.add(2);
		vc.add(0, 10);
		System.out.println(vc);
		vc.set(2, 34);
		System.out.println(vc);
		System.out.println(vc.capacity());

		System.out.println(vc.elementAt(1));
		System.out.println(vc.firstElement());
		System.out.println(vc.lastElement());
		System.out.println(vc.indexOf(2));
		System.out.println(vc.contains(34));
		vc.remove(2);
		System.out.println(vc);
		vc.ensureCapacity(3);
		System.out.println(vc.capacity());
		vc.forEach(System.out::println);
		System.out.println(vc.size());
		System.out.println(vc.isEmpty());
	}

}
