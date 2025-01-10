package tutorial;

// Recursion 
public class Tut13 {
	// to print number like for loop
	public static int fibbo(int no) {
		System.out.println(no);
		if (no == 0)
			return 0;
		return fibbo(no - 1);
	}

	public static void main(String[] args) {
		System.out.println(fibbo(7));
	}

}
