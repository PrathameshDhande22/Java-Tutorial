package tutorial;

//threads
/*
 * Threads can be created in 2 ways 
 * 1. by extending thread class
 * 2. by implementing runnable class
 * 3. by annomyous inner class
 * 
 * In this tutorial we are going to use thread class
 */

class Mythread extends Thread {

	@Override
	public void run() {
		System.out.println("Runinng the thread1.....");
	}

}

class Mythread2 extends Thread {

	@Override
	public void run() {
		System.out.println("Running the thread2.....");
	}

}

public class Tut26 {

	public static void main(String[] args) {
		Mythread th = new Mythread();
		Mythread2 th2 = new Mythread2();
		th2.start();
		th.start();
	}

}
