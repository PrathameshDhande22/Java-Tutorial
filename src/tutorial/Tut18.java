package tutorial;

//String buffer
//as you knoẇ that we cannot change the string but using stringbuffer or string joiner you can do this type of stuff
public class Tut18 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Prathamesh");
		// methods in StringBuffer
		System.out.println(sb);
		sb.append(" Dhande");
		System.out.println(sb);
		System.out.println(sb.reverse());
		System.out.println(sb.capacity());
		sb.delete(11, 16);
		sb.reverse();
		System.out.println(sb);
		sb.insert(4, "Inserted");
		System.out.println(sb);
	}

}
