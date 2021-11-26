package elementTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkTest {

	private WebDriver driver;
	private String linkUrl = "https://demoqa.com/links";

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		//setup the browser
		driver = new ChromeDriver();
		
		//maximize the browser window
		driver.manage().window().maximize();
		
		//navigate to the URL
		driver.navigate().to(linkUrl);
	}	
	
	@Test(description="Link text")
	public void linkText() {
		By linkElementLocator = By.linkText("Home");
		WebElement linkElement = driver.findElement(linkElementLocator);
		
		linkElement.click();	
	}	
	
	@Test(description="Partial Link text")
	public void partialLinkText() {
		By linkElementLocator = By.partialLinkText("Create");
		WebElement linkElement = driver.findElement(linkElementLocator);
		
		linkElement.click();	
	}
	
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
