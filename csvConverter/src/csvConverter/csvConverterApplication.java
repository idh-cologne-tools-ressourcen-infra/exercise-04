package csvConverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.*;

public class csvConverterApplication {

	public static void main(String[] args) {
		 Reader in = null;
		
		 try {
			 in = new BufferedReader(new FileReader(new File("../data/train.csv")));

			 CSVParser parser = CSVFormat.DEFAULT.parse(in);
			 List<CSVRecord> records = parser.getRecords();
			 List<String> header = new ArrayList<>();
			 List<String> row = null;
			 for(String field : records.remove(0)) {
				 header.add(field);
			 }
			 
			 CSVPrinter printer = new CSVPrinter(new BufferedWriter(new FileWriter(new File("../data/out.csv"))), CSVFormat.DEFAULT.withHeader(header.toArray(new String[header.size()])));
				 for (CSVRecord record : records) {
					 row = new ArrayList<>();
					 for(int i=0;i<record.size();i++) {
						 if(header.get(i).equals("Name")) {
							 row.add(record.get(i).replaceAll(" \"[^\"]*\"", ""));
						 }
						 else {
							 row.add(record.get(i));
						 }
					 }
					 printer.printRecord(row);
				 }
				 printer.close(true);
				 

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
