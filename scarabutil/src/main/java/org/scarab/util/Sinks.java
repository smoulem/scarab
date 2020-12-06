package org.scarab.util;

import java.util.ArrayList;
import java.util.List;

import org.scarab.core.Record;
import org.scarab.core.Sink;

public class Sinks {

	private class Entry {

		private String channelName;
		private Sink sink;

		private Entry(String channelName, Sink sink) {
			this.channelName = channelName;
			this.sink = sink;
		}
	}

	private List<Entry> entries = new ArrayList<>();

	public void addSink(String channelName, Sink sink) {
		this.entries.add(new Entry(channelName, sink));
	}

	public void emit(String channelName, Record record) {

		for (Entry entry : this.entries) {
			if (entry.channelName == channelName) {
				entry.sink.record(record);
			}
		}
	}
}
