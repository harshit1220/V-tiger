package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {
	
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("src\\test\\resources\\loginCredentials.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
