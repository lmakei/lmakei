package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	private By email = By.cssSelector("input[id='login_email_input']");
	private By password = By.cssSelector("input[id='login_password_input']");
	private By close =  By.cssSelector("a.close");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public void close() {
		driver.findElement(close).click();
	}
}