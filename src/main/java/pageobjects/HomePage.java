package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Qafox.com']")
	private WebElement HomepageText;

	@FindBy(xpath = ("//a[@title='My Account']"))
	private WebElement MyAccountlink;

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement RegisterLink;

	public WebElement HomepageText() {
		return HomepageText;
	}

	public WebElement MyAccountLink() {
		return MyAccountlink;
	}

	public WebElement RegisterLink() {
		return RegisterLink;
	}
}
