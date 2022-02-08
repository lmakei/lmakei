package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	private By signIn = By.cssSelector(".menu_icon.need2login");
	private By tittle = By.linkText("MAKIAŽUI");
	private By discountCard = By.cssSelector("a[class='menu_icon hidden-sm hidden-xs']");
	private By cart = By.cssSelector(".cart_icon.menu_icon");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {
		driver.findElement(signIn).click();
		return new LoginPage(driver);
	}

	public WebElement getTittle() {
		return driver.findElement(tittle);
	}
	public boolean isCartDisplayed() {
		return driver.findElement(cart).isDisplayed();
	}
	public boolean isDiscoundCardDisplayed() {
		return driver.findElement(discountCard).isDisplayed();
	}
}
