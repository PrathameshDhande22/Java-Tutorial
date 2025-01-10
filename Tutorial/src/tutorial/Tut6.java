package tutorial;

//Types of printing
public class Tut6 {
	public static void main(String[] args) {
		// println
		System.out.println("Prathamesh Dhande using println");
		// print
		System.out.print("Prathamesh using print");
		System.out.print("Prathamesh using print 2nd Time");
		// printf like in c
		int a = 1;
		System.out.printf("\nPrathamesh dhande is using printf value is %d", a);
		// err prints a error
		System.err.println("\nErrored has occured");
		// format
		System.out.format("Prathamesh value is %d", a);
	}
}
/*
 * Output: 
 * Prathamesh Dhande using println
Prathamesh using printPrathamesh using print 2nd Time
Prathamesh dhande is using printf value is 1
Errored has occured
Prathamesh value is 1
 */
