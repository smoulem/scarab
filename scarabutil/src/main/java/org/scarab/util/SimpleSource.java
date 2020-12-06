package org.scarab.util;

import org.scarab.core.Record;
import org.scarab.core.Sink;
import org.scarab.core.Source;

public class SimpleSource implements Source {

	private Sinks sinks = new Sinks();
	Record[] records;

	public SimpleSource(Record[] records) {
		this.records = records;
	}

	@Override
	public void addSink(String channelName, Sink sink) {
		this.sinks.addSink(channelName, sink);
	}

	@Override
	public void start() {

		for (Record record : this.records) {
			this.sinks.emit("foo", record);
		}
	}

}
