package seleniumnew;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumManagerTests {
	private WebDriver driver;
	private String appUrl = "https://books-pwakit.appspot.com/explore?q=";

	By sr_top = By.tagName("book-app");
	By by_searchBox = By.id("input");

	@Test(description = "ShadowDOM Test")
	public void tryShadowDomTestChrome() throws InterruptedException {

		// setup the browser
		driver = new ChromeDriver();

		// maximize the browser window
		driver.manage().window().maximize();

		// navigate to the URL
		driver.navigate().to(appUrl);

		// find top area
		SearchContext shadowRootTop = driver.findElement(sr_top).getShadowRoot();

		// find toolbar's shadow root
		WebElement searchBox = shadowRootTop.findElement(by_searchBox);

		// type into the search box
		searchBox.sendKeys("Hi Selenium Shadow dom");
		System.out.println("Test execution done");
	}

	@Test(description = "ShadowDOM Test")
	public void tryShadowDomTestEdge() throws InterruptedException {

		// setup the browser
		driver = new EdgeDriver();

		// maximize the browser window
		driver.manage().window().maximize();

		// navigate to the URL
		driver.navigate().to(appUrl);

		// find top area
		SearchContext shadowRootTop = driver.findElement(sr_top).getShadowRoot();

		// find toolbar's shadow root
		WebElement searchBox = shadowRootTop.findElement(by_searchBox);

		// type into the search box
		searchBox.sendKeys("Hi Selenium Shadow dom");
		System.out.println("Test execution done");
	}

	@Test(description = "ShadowDOM Test")
	public void tryShadowDomTestFirefox() throws InterruptedException {

		// setup the browser
		driver = new FirefoxDriver();

		// maximize the browser window
		driver.manage().window().maximize();

		// navigate to the URL
		driver.navigate().to(appUrl);

		// find top area
		SearchContext shadowRootTop = driver.findElement(sr_top).getShadowRoot();

		// find toolbar's shadow root
		WebElement searchBox = shadowRootTop.findElement(by_searchBox);

		// type into the search box
		searchBox.sendKeys("Hi Selenium Shadow dom");
		System.out.println("Test execution done");
	}

	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
		// driver.quit();
	}
}
