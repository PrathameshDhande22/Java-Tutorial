package tutorial;

//Operators
public class Tut4 {
	public static void main(String[] args) {

		//Conditional Operators
		int a=1;
		System.out.println(a>1?"yes":"No");
		a=2;
		System.out.println(a>1?"yes":"No");
		
		//increment and decrement operator
		System.out.println("Value of a is "+a);
		System.out.println("Incrementing "+a++);
		System.out.println("Incremented to "+a);
		System.out.println(++a);
		
		System.out.println("Value of a is "+a +"\nDecrementing "+ a--+
				"\nDecremented to :"+a+"\nDecrementing Forward "+--a);
	}
}

/*Output:
 * No
yes
Value of a is 2
Incrementing 2
Incremented to 3
4
Value of a is 4
Decrementing 4
Decremented to :3
Decrementing Forward 2
*/
