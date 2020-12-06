package org.scarab.components;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.scarab.core.Sink;
import org.scarab.core.Source;
import org.scarab.util.ArrayRecord;
import org.scarab.util.Sinks;

public class CSVFileSource implements Source {

	private Sinks sinks = new Sinks();
	private String filename;

	public CSVFileSource(Properties properties) {
		this.filename = properties.getProperty("source.filename");
	}

	public CSVFileSource(String filename) {
		this.filename = filename;
	}

	@Override
	public void addSink(String channelName, Sink sink) {
		this.sinks.addSink(channelName, sink);
	}

	@Override
	public void start() {
		try {
			Reader in = new FileReader(this.filename);
			Iterable<CSVRecord> csvRecords = CSVFormat.DEFAULT.parse(in);

			for (CSVRecord csvRecord : csvRecords) {
				int fieldCount = csvRecord.size();
				Object[] fields = new Object[fieldCount];

				for (int fieldIndex = 0; fieldIndex < fieldCount; fieldIndex++) {
					fields[fieldIndex] = csvRecord.get(fieldIndex);
				}

				sinks.emit("default", new ArrayRecord(fields));
			}

		} catch (IOException e) {
			// TODO Wrap and throw
			System.out.println(e.getMessage());
		}
	}

}
