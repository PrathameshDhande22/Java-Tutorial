package tutorial;

//threads by implementing runnable interface
class ContThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Running The Thread in Contthread Class");
	}

}

public class Tut27 {
	public static void main(String[] args) {
		ContThread th1 = new ContThread(); // creates the class instance of the class implemented the runnable interface
		Thread th = new Thread(th1); // creates the thread class
		th.start();
		//methods in thread
		System.out.println(th.getId());
		System.out.println(th.getName());
		System.out.println(th.getPriority());
		System.out.println(th.getState());
	}
}
