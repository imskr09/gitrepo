package tests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {

	public WebDriver driver;
	Logger log;

	@Test(dataProvider="logindata")
	public void Login(String username, String password) throws IOException, InterruptedException {

		
		LoginPage login = new LoginPage(driver);

		String ActualLoginText = login.LoginLandingPage().getText();
		AssertJUnit.assertEquals(ActualLoginText, "Login");

		login.Email().sendKeys(username);
		login.Password().sendKeys(password);
		login.LoginButton().click();
		
		log.debug("User logged in successfully"+ username);
		Thread.sleep(3000);
		log.info("login success");
		log.error("error log");

	}
	
	@BeforeMethod
	public void openLoginPage() throws IOException {
		log = LogManager.getLogger(LoginTest.class);
		driver = initlizeDriver();
		log.debug("driver initiated");
		driver.get(prop.getProperty("loginurl"));	
	}
	
	@AfterMethod
	public WebDriver tearDown() {
		driver.close();
		return driver;
	}
	
	@DataProvider(name="logindata")
	public Object[][] getLoginData() {
		return new Object[][] {
			{"luv2@gmail.com", "Luv001"}
		
		};
	}

}
