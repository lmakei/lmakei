package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver InitializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		prop.load(fis);
	    String browserName = prop.getProperty("browser");
		// String browserName = System.getProperty("browser"); if parameter is given via Maven (-Dbrowser=chrome)
		if (browserName.contains("headless")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/resources/geckodriver");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
		}
		else if (browserName.equals("chrome"))  {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/resources/geckodriver");
			driver = new FirefoxDriver();
	}
		return driver;
	}
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		this.driver = driver;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
}
