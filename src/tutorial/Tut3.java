package tutorial;

import java.util.Scanner;

//Input from the user
public class Tut3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Number :");
		//for printing no
		int no=sc.nextInt();
		System.out.println("Entered Number is "+ no);
		//for printing string
		System.out.println("Enter Your Name :");
		String name=sc.next();
		System.out.println("Entered Name is :"+name);
		System.out.println("Enter Your Full Name :");
		sc.nextLine();
		String nameLong=sc.nextLine();
		System.out.println("Entered full Name is:"+nameLong);
		sc.close();
	}
}

/*
 * Output:
 * Enter a Number :
2
Entered Number is 2
Enter Your Name :
Prathamesh dhande
Entered Name is :Prathamesh
Enter Your Full Name :
Prathamesh dhande
Entered full Name is:Prathamesh dhande

*/
