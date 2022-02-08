package lmakei;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateDiscountCard extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initializedriver() throws IOException {
		driver = InitializeDriver();
		// driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validateDiscountCard() throws IOException {
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.isDiscoundCardDisplayed());
		log.info("Successfully validated discount card");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}