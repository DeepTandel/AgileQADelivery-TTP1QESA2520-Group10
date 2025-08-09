package com.cab.cucumber.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
		public static  Properties readProperty() {
			Properties properties = new Properties();;
			String fileName = ".\\src\\test\\java\\com\\cab\\cucumber\\configs\\configuration.properties";
			try {
				FileInputStream fis = new FileInputStream(fileName);
				properties.load(fis);
			} catch(Exception e) {
				System.out.println("Exception :"+e);
			}
			return properties;
		}
}
