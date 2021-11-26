package elementTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	private WebDriver driver;
	private String radioBtnUrl = "https://demoqa.com/radio-button";

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		//setup the browser
		driver = new ChromeDriver();
		
		//maximize the browser window
		driver.manage().window().maximize();
		
		//navigate to the URL
		driver.navigate().to(radioBtnUrl);
	}	
	
	@Test(description="Select Radio Btn")
	public void selectRadioBtn() {
		By rbImpressive = By.id("impressiveRadio");
		WebElement rbImpressiveElement = driver.findElement(rbImpressive);
		
		rbImpressiveElement.click();
	}
	
	@Test(description="Is Selected Radio Btn")
	public void isSelectedRadioBtn() {
		By rbImpressive = By.id("impressiveRadio");
		WebElement rbImpressiveElement = driver.findElement(rbImpressive);
		
		System.out.println("Is Impressive RB selected: "+ rbImpressiveElement.isSelected());
		WebElement impressiveRb = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
		impressiveRb.click();
		
		System.out.println("Is Impressive RB selected: "+ rbImpressiveElement.isSelected());
	}
	
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
