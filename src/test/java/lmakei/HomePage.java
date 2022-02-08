package lmakei;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initializedriver() throws IOException {
		driver = InitializeDriver();
		// driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void BasePageNavigation(String username, String password, String text) throws IOException {
		LandingPage lp = new LandingPage(driver);
		LoginPage loginp = lp.getLogin();
		WebDriverWait d = new WebDriverWait(driver, 5);
		d.until(ExpectedConditions.elementToBeClickable(loginp.getEmail()));
		loginp.getEmail().sendKeys(username);
		loginp.getPassword().sendKeys(password);
		log.info("Email and password of " + text + " are enetred");
		loginp.close();
	}
	

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][3];
		// non-restricted user
		data[0][0] = "lada.test@mail.com";
		data[0][1] = "password1";
		data[0][2] = "non-restricted user";

		return data;
	}

}