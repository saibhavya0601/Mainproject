package com.AutomationScript.Utils;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseUI {

	public static Properties prop;
	static WebDriver driver = null;
	public static String data[];
	final String baseUrl = "https://www.globoforce.net/microsites/t/home?client=cognizant&setCAG=true";

	// Open the Practo website using specified browser
	public void openBrowserAndNavigateToPracto(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			if (prop == null) {
				prop = new Properties();
				try {
					FileInputStream file = new FileInputStream(System.getProperty("user.dir")
							+ "\\src\\main\\resources\\ObjectRepository\\projectConfig.properties");
					prop.load(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			driver.manage().window().maximize();
			driver.get(baseUrl);
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Verify if correct page is loaded
			String pageTitle = driver.getTitle();
			Assert.assertEquals(pageTitle, "Welcome");
		}
		// Automate using firefox browser
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			if (prop == null) {
				prop = new Properties();
				try {
					FileInputStream file = new FileInputStream(System.getProperty("user.dir")
							+ "\\src\\main\\resources\\ObjectRepository\\projectConfig.properties");
					prop.load(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			driver.manage().window().maximize();
			driver.get(baseUrl);
			// Verify if correct page is loaded
			String pageTitle = driver.getTitle();
			Assert.assertEquals(pageTitle,
					"Store");
		}
	}

	/*public void navigateToBBQ() {
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Store_xpath"))));
		clickElement("Store_xpath");
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ShopAll_xpath"))));
		clickElement("ShopAll_xpath");
	}*/

	// Enter text into a field
	public void enterText(String nameKey, String text) {
		getElement(nameKey).sendKeys(text);
	}

	// Click a web element
	public void clickElement(String locatorKey) {

		getElement(locatorKey).click();

	}

	// Identify and return webelement on a page

	public WebElement getElement(String locatorKey) {
		WebElement element = null;

		if (locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_partialLinkText")) {
			element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(prop.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(prop.getProperty(locatorKey)));
		} else if (locatorKey.endsWith("_CssSelector")) {
			element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
		}
		return element;

	}

	public List<WebElement> getElements(String locatorKey) {
		List<WebElement> elements = null;
		if (locatorKey.endsWith("_xpath")) {
			elements = driver.findElements(By.xpath(prop.getProperty(locatorKey)));
		}
		return elements;
	}

	// Close all instances of the browser
	public void closeBrowser() {
		driver.quit();
	}

}
