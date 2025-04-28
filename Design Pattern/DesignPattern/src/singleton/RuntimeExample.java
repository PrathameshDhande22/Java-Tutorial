package singleton;

public class RuntimeExample {
	public static void main(String[] args) {
		// The Runtime Library - Each OS contains only one runtime hence we instantiate
		// only one class.
		Runtime runtime = Runtime.getRuntime();
		System.out.println(runtime.availableProcessors());
	}
}
