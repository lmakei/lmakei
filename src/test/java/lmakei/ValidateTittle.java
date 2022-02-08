package lmakei;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTittle extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage lp;

	@BeforeTest
	public void initializedriver() throws IOException {
		driver = InitializeDriver();
		log.info("Driver is initialized");
		// driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		log.info("Navigate to Home page");
	}

	@Test
	public void validateTittle() throws IOException {
		lp = new LandingPage(driver);
		// compare the text from the browser with actual text
		Assert.assertEquals(lp.getTittle().getText(), "MAKIAŽUI");
		log.info("Successfully validated title text");
	}

	@Test
	public void validateCart() throws IOException {
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.isCartDisplayed(),true);
		log.info("Successfully validated the footer");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}