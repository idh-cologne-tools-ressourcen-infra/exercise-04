import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/*
 * This solution uses the CSV parsing library Apache Commons CSV
 */
public class Convert {
	static File inputFile = new File("data/train.csv");
	static File outputFile = new File("data/train2.csv");

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// A parser object to read in the old file. We specify the format to use the
		// first row as header
		CSVParser parser = new CSVParser(new FileReader(inputFile), CSVFormat.DEFAULT.withFirstRecordAsHeader());

		// A printer object to print out the new file
		CSVPrinter printer = new CSVPrinter(new FileWriter(outputFile), CSVFormat.DEFAULT.withFirstRecordAsHeader());

		// print the header info
		printer.printRecord(parser.getHeaderNames());

		// Iterate over all records ( = line)
		for (CSVRecord record : parser.getRecords()) {
			// Iterate over all columns
			for (String column : parser.getHeaderNames()) {

				// Get value of this cell
				String o = record.get(column);

				// If the column name is "Name", we remove the nick names
				// with a regular expression
				if (column.equals("Name")) {
					o = o.replaceFirst("\"[^\"]+\"", "");
				}

				// add o to the output printer
				printer.print(o);
			}
			// mark the end of a line
			printer.println();
		}
	}
}