package elementTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTest {

	private WebDriver driver;
	private String checkBoxUrl = "https://demoqa.com/checkbox";

	@BeforeMethod
	public void launchBrowser() {
		// Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\magesh.nagamani\\Downloads\\drivers\\chromedriver.exe");

		ChromeDriver chromeDriver = new ChromeDriver();
		// setup the browser
		driver = new ChromeDriver();

		// maximize the browser window
		driver.manage().window().maximize();

		// navigate to the URL
		driver.navigate().to(checkBoxUrl);
	}

	@Test(description = "select checkbox")
	public void selectCheckBox() {
		By expandCB = By.cssSelector("button[title='Expand all']");
		WebElement cbExpandAll = driver.findElement(expandCB);

		// expand all cb
		cbExpandAll.click();

		By cbReactLocator = By.cssSelector("#tree-node ol>li:nth-of-type(2)>ol>li:nth-of-type(1)>ol>li .rct-checkbox");
		WebElement cbReact = driver.findElement(cbReactLocator);

		// select React-CB
		cbReact.click();
	}

	@Test(description = "is selected checkbox")
	public void isCheckBoxSelected() {
		By expandCB = By.cssSelector("button[title='Expand all']");
		WebElement cbExpandAll = driver.findElement(expandCB);

		// expand all cb
		cbExpandAll.click();

		By cbReactLocator = By.cssSelector("#tree-node ol>li:nth-of-type(2)>ol>li:nth-of-type(1)>ol>li .rct-checkbox");
		WebElement cbReact = driver.findElement(cbReactLocator);

		By cbReactSelectedLocator = By
				.cssSelector("#tree-node ol>li:nth-of-type(2)>ol>li:nth-of-type(1)>ol>li #tree-node-react");
		WebElement cbReactSelected = driver.findElement(cbReactSelectedLocator);

		System.out.println("Is React CB selected: " + cbReactSelected.isSelected());

		// select React-CB
		cbReact.click();

		// is React-CB selected
		cbReactSelected = driver.findElement(cbReactSelectedLocator);
		System.out.println("Is React CB selected: " + cbReactSelected.isSelected());
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
