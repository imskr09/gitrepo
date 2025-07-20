package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	private static final String FirstName = null;
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Register Account']")
	private WebElement RegisterLandingPage;
	
	@FindBy(id="input-firstname")
	private WebElement Firstname;
	
	@FindBy(id ="input-lastname")
	private WebElement LastName;
	
	@FindBy(id="input-email")
	private WebElement Email;
	
	@FindBy(id="input-telephone")
	private WebElement Telephone;
	
	@FindBy(id="input-password")
	private WebElement Password;
	
	@FindBy(id="input-confirm")
	private WebElement ConfirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement Checkbox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement Button;
	
	
	public WebElement RegisterLandingPage() {
		return RegisterLandingPage;
	}
	
	public WebElement Firstname() {
		return Firstname;
	}
	
	public WebElement LastName() {
		return LastName;
	}
	
	public WebElement Email() {
		return Email;
	}
	
	public WebElement Telephone() {
		return Telephone;
	}
	
	public WebElement Password() {
		return Password;
	}
	
	public WebElement ConfirmPassword() {
		return ConfirmPassword;
	}
	
	public WebElement Checkbox() {
		return Checkbox;
	}
	
	public WebElement Button() {
		return Button;
	}
}
