package tutorial;

//Arrays
public class Tut9 {
	public static void main(String[] args) {
		// Array can be Declared in 2ways
		int[] array1 = new int[4];
		int[] arr = { 1, 2, 3, 4 };

		// String  arrays
		String[] strarray = { "Prat", "Nid", "Dhan" };

		// iterating array
		System.out.println("Using for Loop");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		// for each loop
		System.out.println("Using For each Loop");
		for (int i : arr) {
			System.out.println(i);
		}

		System.out.println("Iterating String");
		for (String s : strarray) {
			System.out.println(s);
		}

		// creating 2d arrays
		System.out.println("Created 2D Arrays");
		int[][] arr2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 7 } };
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.printf("arr2[%d][%d]=%d\n", i, j, arr2[i][j]);
			}
		}

	}
}
