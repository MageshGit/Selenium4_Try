package seleniumnew;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium410Try {
	private WebDriver driver;
	private String appUrl = "https://books-pwakit.appspot.com/explore?q=";

	By sr_top = By.tagName("book-app");
	By by_searchBox = By.id("input");

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		// setup the browser
		driver = new ChromeDriver();

		// maximize the browser window
		driver.manage().window().maximize();

		// navigate to the URL
		driver.navigate().to(appUrl);
	}

	@Test(description = "ShadowDOM Test")
	public void tryShadowDomTest() throws InterruptedException {
		// find top area
		SearchContext shadowRootTop = driver.findElement(sr_top).getShadowRoot();

		// find toolbar's shadow root
		WebElement searchBox = shadowRootTop.findElement(by_searchBox);

		// type into the search box
		searchBox.sendKeys("Hi Selenium Shadow dom");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
