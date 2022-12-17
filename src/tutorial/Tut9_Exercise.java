package tutorial;

import java.util.Arrays;

//Reverse an array
public class Tut9_Exercise {

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		System.out.println("Array :" + Arrays.toString(arr));
		int total = arr.length;
		int rem = (int) Math.floor(total / 2);
		for (int i = 0; i < rem; i++) {
			int temp = arr[total - (i + 1)];
			arr[total - (i + 1)] = arr[i];
			arr[i] = temp;
		}
		System.out.println("Array After Reversing :" + Arrays.toString(arr));
	}

}
