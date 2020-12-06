package org.scarab.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

	public Properties loadProperties(String name) {
    	Properties properties = null;

    	try {
        	properties = new Properties();
        	InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name);
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	return properties;
    }
}
