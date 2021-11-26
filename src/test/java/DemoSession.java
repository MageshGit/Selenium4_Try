import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoSession {
	public static void main(String args[]) throws InterruptedException, MalformedURLException {
		// Setting system properties of ChromeDriver
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\magesh.nagamani\\Downloads\\drivers\\chromedriver.exe");

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\magesh.nagamani\\Downloads\\drivers\\geckodriver.exe");

		String appUrl = "https://demoqa.com/automation-practice-form";

		// launch chrome browser on saucelabs
		ChromeOptions options = new ChromeOptions();
		options.setPlatformName("Windows 10");
		options.setBrowserVersion("latest");

		Map<String, Object> sauceOptions = new HashMap<String, Object>();
		sauceOptions.put("username", "asp_prasanna_vigneshwar");
		sauceOptions.put("accessKey", "896d9902-63ff-4bb5-bd77-0217bb4a9558");

		options.setCapability("sauce:options", sauceOptions);
		URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");

		WebDriver obj = new RemoteWebDriver(url, options);
		// WebDriver obj = new RemoteWebDriver(new URL("http://localhost:4444"), caps);

		// WebDriver obj1 = new RemoteWebDriver(new URL("http://localhost:4444"), caps);

		// launch chrome browser
		// ChromeDriver obj = new ChromeDriver();

		// maximize the chrome window
		obj.manage().window().maximize();

		// load the given url
		obj.get(appUrl);

		// By firstNameLocator = By.id("firstName");

		By firstNameLocatorOfTypeClass = By.cssSelector(".form-control");

		// find the firstName WebElement
		WebElement firstNameElement = obj.findElement(firstNameLocatorOfTypeClass);

		List<WebElement> elements = obj.findElements(firstNameLocatorOfTypeClass);

		// type email
		elements.get(2).sendKeys("email.com");

		// type 'testing' into firstName text box
		// firstNameElement.sendKeys("testing");

		Thread.sleep(5000);
	}
}
