package org.scarab.core;

public interface Source {

	void addSink(String channelName, Sink sink);

	void start();
}
