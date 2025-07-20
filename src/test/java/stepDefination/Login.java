package stepDefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base {

	public WebDriver driver;
	LoginPage login;

	@Given("Open the Browser")
	public void open_the_browser() throws IOException {
		driver = initlizeDriver();
	}

	@And("Navigate to Login page")
	public void navigate_to_login_page() {
		driver.get(prop.getProperty("loginurl"));
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		login = new LoginPage(driver);
		login.Email().sendKeys(username);
		login.Password().sendKeys(password);

	}

	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {
		login.LoginButton().click();
	}

	@Then("verify user is able to successfully login")
	public void verify_user_is_able_to_successfully_login() {
		if (login.LoginSuccess().isDisplayed()) {
			System.out.println("Login success");
		} else {
			Assert.assertTrue(false);
		}

	}


	@After
	public void closeBrowser() {
		driver.close();
	}
	

}
