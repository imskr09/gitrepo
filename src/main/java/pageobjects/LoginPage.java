package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Login']")
	private WebElement LoginLandingPage;
	
	@FindBy(id="input-email")
	private WebElement Email;
	
	@FindBy(id="input-password")
	private WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//h2[text()='My Account']")
	 WebElement LoginSuccess;
	
	public WebElement LoginLandingPage() {
		
		return LoginLandingPage;
	}

	public WebElement Email() {
		return Email;
	}
	
	public WebElement Password() {
		return Password;
	}
	
	public WebElement LoginButton() {
		return LoginButton;
	}
	public WebElement LoginSuccess() {
		return LoginSuccess;
	}
	
	

}
