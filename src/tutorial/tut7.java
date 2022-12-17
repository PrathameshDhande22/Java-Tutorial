package tutorial;

//conditionals statement
public class tut7 {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		if (a == 1) {
			System.out.println("Yes");
		}
		// || or , && and, !not
		else if (a > 1 || b > 1) {
			System.out.println("Yes a is greater than 1 or b is greater than 1");
		}

		else {
			System.out.println("No");
		}
		if (a != 2) {
			System.out.println("a is not equal to 2");
		}

		// switch case
		switch (a) {
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		default:
			System.out.println("Default");
		}

	}
}
/*
Output:
Yes
a is not equal to 2
1
*/