package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import resources.Base;

public class RegisterTest extends Base {

	public WebDriver driver;

	@Test(dataProvider = "registerdata")
	public void Register(String firstname, String lastname, String email, String phone, String password,
			String confirmpassword) throws IOException, InterruptedException {

		HomePage home = new HomePage(driver);

		// Verifying that we have landed on home page
		String sourcetext = home.HomepageText().getText();
		AssertJUnit.assertEquals(sourcetext, "Qafox.com");
		System.out.println("on homepage");

		// click on MyAccount and then click on register link

		home.MyAccountLink().click();
		System.out.println("clicked myaccount link");

		home.RegisterLink().click();
		System.out.println("clicked registertion link");

		// Verifying register page opened
		RegisterPage reg = new RegisterPage(driver);
		String reghome = reg.RegisterLandingPage().getText();
		AssertJUnit.assertEquals(reghome, "Register Account");

		// Fill all the fields
		reg.Firstname().sendKeys(firstname);
		reg.LastName().sendKeys(lastname);
		reg.Email().sendKeys(email);
		reg.Telephone().sendKeys(phone);
		reg.Password().sendKeys(password);
		reg.ConfirmPassword().sendKeys(confirmpassword);
		reg.Checkbox().click();
		reg.Button().click();
		Thread.sleep(3000);
		System.out.println("clicked login button");

		// Handling alert box
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			System.out.println("No alert populated");
		}

		// Registration successful
		String actualtitle = driver.getTitle();
		String expectedtitle = "Your Account Has Been Created!";
		// Assert.assertEquals(actualtitle,expectedtitle);
		if (actualtitle.equalsIgnoreCase(expectedtitle)) {
			Assert.assertTrue(true, "registration pass");
		} else {
			Assert.assertTrue(false,"registration failed");
		}

	}

	@BeforeMethod
	public void openRegpage() throws IOException {
		driver = initlizeDriver();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public WebDriver tearDown() {
		driver.close();
		return driver;
	}

	@DataProvider(name = "registerdata")
	public Object[][] getRegisterdata() {

		return new Object[][] {

				{ "sajan", "Kumar", "saj144@gmail.com", "8987226545", "Akash123", "Akash123" }

		};
	}

}
