package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver = null;
	public Properties prop;

	public WebDriver initlizeDriver() throws IOException {

		prop = new Properties();
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/data.properties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);

		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}
	
	public String takeScreenshot(String testName, WebDriver driver) throws IOException {
	    // Define screenshot folder
	    String folderPath = System.getProperty("user.dir") + "/Screenshots";
	    File dir = new File(folderPath);

	    // Create folder if it doesn't exist
	    if (!dir.exists()) {
	        boolean created = dir.mkdirs();
	        if (created) {
	            System.out.println("✅ 'Screenshots' folder created at: " + folderPath);
	        } else {
	            System.out.println("❌ Failed to create 'Screenshots' folder.");
	        }
	    }

	    // Capture screenshot
	    File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String destPath = folderPath + "/" + testName + ".png";
	    FileUtils.copyFile(sourceFile, new File(destPath));
	    System.out.println("📸 Screenshot saved to: " + destPath);
	    
	    return destPath;
	}

}
