package org.scarab;

import java.lang.reflect.InvocationTargetException;

import org.scarab.core.Sink;
import org.scarab.core.Source;
import org.scarab.core.Transformer;
import org.scarab.util.ComponentFactory;

public class Scarab {

	public static void main(String[] args) {
		try {
			ComponentFactory componentFactory = new ComponentFactory();
			Source source = componentFactory.create(System.getProperty("source.properties.filename"), "source");
			Transformer transformer = componentFactory.create(System.getProperty("transformer.properties.filename"), "transformer");
			Sink sink = componentFactory.create(System.getProperty("sink.properties.filename"), "sink");
			source.addSink("default", transformer);
			transformer.addSink("default", sink);
			source.start();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
