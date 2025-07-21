package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

import org.testng.annotations.Test;

public class TestFour extends Base{
	public WebDriver driver;
	@Test
	public void fourTest() throws IOException, InterruptedException {
		
		driver = initlizeDriver();
		driver.get("https://smartprogramming.in/core-java-free-course");
		Thread.sleep(3000);

		System.out.println("Sajan has changed the code");
		
		Assert.assertTrue(false, "Forcing failure to test screenshot");
		System.out.println("sbranch for merge flow");



		
	}
	
	@AfterMethod
public void closeWindow() {
	
	driver.close();
}
}
