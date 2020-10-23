import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyRead {

	private Properties property;
	private final String FilePath = "Data//config.properties";		// Path of config.properties file

	public PropertyRead() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(FilePath));
			property = new Properties();
			try {
				property.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("File not found at " + FilePath);
		}
	}

	public String get_chromeDriverPath() {
		String driverPath = property.getProperty("chromeDriverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("Chrome Driver Path is not specified in the config.properties file");
	}

	public String get_Url() {
		String url = property.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Url is not specified in the config.properties file");
	}

	public String get_topic() {
		String topic = property.getProperty("topic");
		if (topic != null)
			return topic;
		else
			throw new RuntimeException("Topic Name is not specified in the config.properties file");
	}

}

