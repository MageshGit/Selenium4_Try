package elementTest;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest {

	private WebDriver driver;
	private String textBoxUrl = "https://demoqa.com/text-box";

	public static final String USERNAME = "mageshn_ycMwp8";
	public static final String AUTOMATE_KEY = "oLhogBxnaXriQVJwVXk7";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public String platformDecider = "";

	@BeforeMethod
	public void launchBrowser() throws MalformedURLException {
		if (platformDecider.equals("local")) {
			// setup the browser
			driver = new ChromeDriver();
		} else {

		}

		// maximize the browser window
		driver.manage().window().maximize();

		// navigate to the URL
		driver.navigate().to(textBoxUrl);
	}

	@Test()
	public void bsRun() throws MalformedURLException {

	}

	@Test(description = "type into text boxes")
	public void textBoxTest_1() {
		By firstName = By.id("userName");
		WebElement txbFirstName = driver.findElement(firstName);

		txbFirstName.sendKeys("ddd");
	}

	@Test(description = "get text from text boxes")
	public void textBoxTest_2() {
		By firstName = By.id("userName");
		WebElement txbFirstName = driver.findElement(firstName);

		txbFirstName.sendKeys("Practice");

		// get text from tb
		String input = txbFirstName.getAttribute("value");
		System.out.println("Text from Textbox: " + input);
	}

	@Test(description = "clear text boxes")
	public void textBoxTest_3() {
		By firstName = By.id("userName");
		WebElement txbFirstName = driver.findElement(firstName);

		txbFirstName.sendKeys("Practice");

		// clear text from tb
		String input = txbFirstName.getAttribute("value");
		System.out.println("Text from Textbox before clearing: " + input);

		// clear the value
		txbFirstName.clear();
		input = txbFirstName.getAttribute("value");
		System.out.println("Text from Textbox after clearing: " + input);
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
