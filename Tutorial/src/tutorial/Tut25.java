package tutorial;

//making Custom Exception
class NotFoundNumber extends Exception {
	private int no;

	public NotFoundNumber(int no) {
		this.no = no;
	}

	// auto generated from eclipse ide
	@Override
	public String getMessage() {
		return "The Number you are Searching is not found %d".formatted(no);
	}

	@Override
	public String toString() {
		return "Not such number found";
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
	}

}

public class Tut25 {

	public static void Number() throws NotFoundNumber {
		// throwing the exception
		int[] arr = { 1, 2, 3 };
		int index = 3;
		if (index > arr.length - 1) {
			throw new NotFoundNumber(index);
		} else {
			System.out.println(arr[index]);
		}

	}

	// throws means saying that be ready there will be possibilty of exception
	public static void main(String[] args) throws NotFoundNumber {
		try {
			Number();
		} catch (NotFoundNumber e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

}
