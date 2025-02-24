package decorator;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputStreams {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("./file.txt");

		InputStream stream = new FileInputStream(file);
		stream=new BufferedInputStream(stream);
		stream=new DataInputStream(stream);
	}
}
