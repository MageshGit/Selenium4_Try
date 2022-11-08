package seleniumnew;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium410Try {
	private WebDriver driver;
	private String appUrl = "https://books-pwakit.appspot.com/explore?q=";

	By sr_top = By.tagName("book-app");
	By by_searchBox = By.id("input");

	@BeforeMethod
	public void launchBrowser() {

		// setup the browser
		driver = new EdgeDriver();

		// maximize the browser window
		driver.manage().window().maximize();

		// navigate to the URL
		driver.navigate().to(appUrl);
	}

	@Test(description = "ShadowDOM Test")
	public void tryShadowDomTest1() throws InterruptedException {
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
		System.out.println(driver.manage().logs().toString());
		driver.close();
		// driver.quit();
	}
}
