package tutorial;

import java.util.Arrays;

//variable Arguments
public class Tut12 {

	public static void sum(int... arr) {// it must be specified ... three dots only
		System.out.println(arr); // it returns the array
		System.out.println(Arrays.toString(arr));
	}

	// variable arguments with one parameter
	public static void withparam(int a, int... arr) {
		System.out.println("a = " + a);
		System.out.println("Array Passed : " + Arrays.toString(arr));
	}

	public static void main(String[] args) {
		sum(1, 2, 3, 4);
		sum(5, 6, 7, 7);
		withparam(1); // passed the one only
		withparam(10, 2, 3, 4, 5);
	}

}
