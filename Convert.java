import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * This solution uses pure java
 */
public class Convert {
	static File inputFile = new File("data/train.csv");
	static File outputFile = new File("data/train2.csv");

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Use buffered reader and writer for line-wise operation
		BufferedReader fr = new BufferedReader(new FileReader(inputFile));
		BufferedWriter fw = new BufferedWriter(new FileWriter(outputFile));

		// iterate over all lines
		String line;

		// The assignment operation (line = fr.readLine()) evaluates to the value
		// assigned, which means it can be compared to something else. Documentation
		// tells us that readLine() returns null if we have reached the end of the file.
		while ((line = fr.readLine()) != null) {

			// replace all occurrences of "", followed by something other than ", followed
			// by "", with nothing
			line = line.replaceAll("\"\"[^\"]+\"\"", "");

			// write the line in the output buffer
			fw.write(line);

			// add a newline
			fw.write("\n");
		}

		fr.close();

		// this is important to remember! If we close the stream before everything was
		// written, the file misses some lines.
		fw.flush();
		fw.close();

	}
}