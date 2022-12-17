package tutorial;

//String
public class Tut5 {
	public static void main(String[] args) {
		// Declaring String can be declared in 2 ways
		// 1st way
		String firstway = "Prathamesh";
		// 2nd way
		String secondway = new String("Dhande");
		// Note : this strings are note changeable means Immutable
		System.out.println(firstway + secondway); // This is String concatenation

		// Methods of String
		System.out.println("CharAt 1 :" + firstway.charAt(1));
		System.out.println(firstway.concat("Prashant")); // another way of concatenation;
		System.out.println(firstway.length()); // length of a String
		System.out.println(firstway.toLowerCase());
		System.out.println(firstway.toUpperCase());
		System.out.println("  kyu".trim());
		System.out.println(firstway.substring(1, 7));
		System.out.println(firstway.repeat(2));
		System.out.println(firstway.contains("t"));
		System.out.println(firstway.replace("t", "z"));
		System.out.println(firstway); // original string is not changed
		System.out.println(firstway.compareTo("Dhande"));
		System.out.println(firstway.equals("Prathamesh"));
		System.out.println(firstway.equals("Prathame"));
		System.out.println(firstway.equalsIgnoreCase("prathamesh"));
		System.out.println(firstway.startsWith("P"));
		System.out.println(firstway.indexOf("r"));

	}
}

/*
 * Output: 
 * PrathameshDhande
CharAt 1 :r
PrathameshPrashant
10
prathamesh
PRATHAMESH
kyu
ratham
PrathameshPrathamesh
true
Prazhamesh
Prathamesh
12
true
false
true
true
1

 */