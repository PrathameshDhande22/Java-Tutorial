package tutorial;

//Try and catch
public class Tut24 {

	public static void main(String[] args) {
		// exception
		try {
			int a = 1 / 1;
			System.out.println(a);
			int[] arr = { 1, 2 };
			System.out.println(arr[2]);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("Exception has occured");
		} catch (ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
		} finally { // executes whether exception is occured or not
			System.out.println("System exited successfully ");
		}
	}

}
