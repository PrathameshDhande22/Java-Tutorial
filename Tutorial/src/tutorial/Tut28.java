package tutorial;

//threads
class Runno extends Thread {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("Running Thread1 : " + i);
		}
	}

}

class Runno2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("Running Thread2 : " + i);
		}
	}
}

public class Tut28 {

	public static void main(String[] args) {
//		RunningThread();
//		ThreadJoin();
	}

	// this method runs the thread but the see the output
	public static void RunningThread() {
		Runno n1 = new Runno();
		Runno2 n2 = new Runno2();
		n1.start();
		n2.start();
	}

	public static void ThreadJoin() {
		try {
			Runno n1 = new Runno();
			Runno2 n2 = new Runno2();
			n1.start();
			n1.join();
			n2.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
