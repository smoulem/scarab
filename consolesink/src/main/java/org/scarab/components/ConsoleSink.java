package org.scarab.components;

import java.util.Properties;

import org.scarab.core.Record;
import org.scarab.core.Sink;

public class ConsoleSink implements Sink {

	public ConsoleSink() { }

	public ConsoleSink(Properties properties) {	}

	@Override
	public void record(Record record) {

		for (int fieldIndex = 0; fieldIndex < record.fieldCount(); fieldIndex++) {
			System.out.print("<" + record.getFieldValue(fieldIndex) + ">");
		}

		System.out.println();
	}

}
