package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

import org.testng.annotations.Test;


public class TestThree extends Base{
	public WebDriver driver;
	@Test
	public void threeTest() throws IOException, InterruptedException {
		
		driver = initlizeDriver();
		driver.get("https://mvnrepository.com/");
		System.out.println("Sajan created this line for sbranch");
		System.out.println("Sajan created this line for sbranch in local to git repo");

		System.out.println("sbranch third commit");



		Thread.sleep(3000);
		//takeScreenshot(null,driver);
		driver.close();
	}

}
