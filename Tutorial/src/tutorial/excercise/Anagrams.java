package tutorial.excercise;

import java.util.Scanner;

class Anagram {
	private String first;
	private String second;
	private char f;
	private String fs;

	public Anagram(String first, String second) {
		this.first = first.toLowerCase();
		this.second = second.toLowerCase();
	}

	public boolean check() {
		if (first.length() != second.length()) {
			return false;
		} else {
			for (int i = 0; i < first.length(); i++) {
				f = first.charAt(i);
				fs = Character.toString(f);
				if (!second.contains(fs)) {
					return false;
				}
			}
			return true;
		}
	}
}

public class Anagrams {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the First Word : ");
		String first = sc.nextLine();
		System.out.print("Enter the Second Word : ");
		String second = sc.nextLine();
		Anagram an = new Anagram(first, second);
		System.out.println(an.check()?"Anagram":"Not Anagrams");
		sc.close();
	}

}
