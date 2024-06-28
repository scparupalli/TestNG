package com.maven.testNG.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {


	    private Properties properties;
	    private static PropertiesUtility instance;

	    private void PropertyUtility() {
	        properties = new Properties();
	        try {
	            FileInputStream input = new FileInputStream("Properties.properties");
	            properties.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static PropertiesUtility getInstance() {
	        if (instance == null) {
	            instance = new PropertiesUtility();
	        }
	        return instance;
	    }

	    public String getProperty(String key) {
	        return properties.getProperty(key);
	    }
	}


