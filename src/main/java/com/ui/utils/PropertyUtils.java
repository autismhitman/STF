package com.ui.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	
	private static Properties properties;
	public static String readValue(String property) {
		
		File file = new File("./src/test/resources/config/QA.properties");
		FileReader reader=null;
		try {
		     reader = new FileReader(file);
		     properties= new Properties();
		     properties.load(reader);
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		
		return properties.getProperty(property.toLowerCase());
	}

}
