package tutorial;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

//file handling
public class Tut35 {

	public static void main(String[] args) {
		// creating the new file
		try {
			File ff = new File("new.txt");
			if (ff.createNewFile()) {
				FileWriter fw = new FileWriter(ff);
				fw.write("Prathamesh is here\nMy name is this");
				fw.close();
			}
			// reading the file
			Scanner sc = new Scanner(ff);
			System.out.println(sc.nextLine());
			sc.close();
			// deleting the file
			if (ff.delete()) {
				System.out.println("Deleted the file successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
