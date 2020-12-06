package org.scarab.components;

import java.util.Properties;

import org.scarab.core.Record;
import org.scarab.core.Sink;
import org.scarab.core.Transformer;
import org.scarab.util.Sinks;

public class ToUpperTransformer implements Transformer {

	private Sinks sinks = new Sinks();

	public ToUpperTransformer(Properties properties) { }

	@Override
	public void addSink(String channelName, Sink sink) {
		this.sinks.addSink(channelName, sink);
	}

	@Override
	public void start() {
	}

	@Override
	public void record(Record record) {

		for (int fieldIndex = 0; fieldIndex < record.fieldCount(); fieldIndex++) {
			String fieldValue = (String)record.getFieldValue(fieldIndex);
			record.setFieldValue(fieldIndex, fieldValue.toUpperCase());
		}

		sinks.emit("default", record);
	}
}
