package _14genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class _1FileUtility {
	
	public String fetchDataFromPropertyFile(String key) throws IOException {
		//Converting Physical Representation of Property File to Java Representation
		FileInputStream fis=new FileInputStream("src/test/resources/PropertyData.properties");
		Properties property = new Properties();
		//Loading the keys of the property file
		property.load(fis);
		return property.getProperty(key);
	}

}
