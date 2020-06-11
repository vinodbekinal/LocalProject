package com.test.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class EnvironmentProperties {
	private static EnvironmentProperties environmentProperties = null;
	public static String TEST_AUTOMATION_URL;
	
	public static final String EXECUTION_TIMESTAMP = new SimpleDateFormat(
			"yyyyMMddhhmm").format(new Date());
	
	EnvironmentProperties() {
		Properties properties = new Properties();
		InputStream output = null;

		try {
			output = new FileInputStream("src/com/test/configurations/config.properties");
			properties.load(output);
			TEST_AUTOMATION_URL = properties.getProperty("TEST_AUTOMATION_URL");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EnvironmentProperties getInstance() {
		if (environmentProperties == null) {
			return new EnvironmentProperties();
		}
		return environmentProperties;
	}
}
