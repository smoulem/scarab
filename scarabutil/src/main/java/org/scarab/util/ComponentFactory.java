package org.scarab.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ComponentFactory {

	private PropertiesLoader propertiesLoader = new PropertiesLoader();

	@SuppressWarnings("unchecked")
	public <T> T create(
		String propertiesFilename,
		String propertiesPrefix)
	throws
		ClassNotFoundException,
		NoSuchMethodException,
		SecurityException,
		InstantiationException,
		IllegalAccessException,
		IllegalArgumentException,
		InvocationTargetException {

		Properties properties = this.propertiesLoader.loadProperties(propertiesFilename);
		System.out.println(properties);
		Class<?> clazz = Class.forName(properties.getProperty(propertiesPrefix + ".class"));
		Constructor<?> constructor = clazz.getConstructor(Properties.class);
		T component = (T)constructor.newInstance(properties);

		return component;
	}

}
