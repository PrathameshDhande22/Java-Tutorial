package adapter;

import java.io.*;

public class InputStreamExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path = System.getProperty("user.dir");
		path = path.concat("/src/adapter/file.txt");

		File file = new File(path);
		// Adaptee
		InputStream filestream = new FileInputStream(file);
		// Adapter
		Reader inputstreamreader = new InputStreamReader(filestream);
		// Client
		BufferedReader reader = new BufferedReader(inputstreamreader);
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();

	}

}
