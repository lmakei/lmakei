package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class stepDefinitions extends base{

    @Given("^Initialize the browser$")
    public void initialize_the_browser() throws Throwable {
		driver = InitializeDriver();
    }

    @When("^User eneters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
    public void user_eneters_something_and_something_and_logs_in(String username, String password) throws Throwable {
    	LoginPage loginp = new LoginPage(driver);
		loginp.getEmail().sendKeys(username);
		loginp.getPassword().sendKeys(password);
    }

    @Then("^Credentials are enetred successfully for \\\"([^\\\"]*)\\\"$")
    public void credentials_are_enetred_successfully(String strArg1) throws Throwable {
    	LoginPage loginp = new LoginPage(driver);
    	Assert.assertNotNull(loginp.getEmail());
    }

    @And("^Navigate to \"([^\"]*)\" website$")
    public void navigate_to_something_website(String strArg1) throws Throwable {
    	driver.get(prop.getProperty(strArg1));
        
    }

    @And("^Click on Login icon in homepage to land on sign in page$")
    public void click_on_login_icon_in_homepage_to_land_on_sign_in_page() throws Throwable {
    	LandingPage lp = new LandingPage(driver);
    	lp.getLogin();
}
}