package com.AutomationScript.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class FindBBQ2 extends BaseUI
{
	
	  
	  //navigating to garden and outdoors
	public void testTwo() throws Exception {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		new WebDriverWait(driver, 50)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ShopAll_xpath"))));
		clickElement("ShopAll_xpath");
		clickElement("Garden_xpath");
		clickElement("BBQ_xpath");
		
	}
	
	//filtering elements from price range 1500 2000
	public void pricefilter()
	{
	new WebDriverWait(driver, 50)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("PriceFilter_xpath"))));
		clickElement("PriceFilter_xpath");
		enterText("MinPrice_xpath","1500");
		enterText("MaxPrice_xpath","2000");
		clickElement("FilterBtn_xpath");
	}
	
	//sorting the elements from high to low
	public void sortby()
	{
		Select dropDown = new Select(getElement("Sort_xpath"));
		dropDown.selectByVisibleText("Price: High to Low");
	}
	
	//retriving the number of results
	public void results1() throws InterruptedException
	{
		new WebDriverWait(driver, 50)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Results_xpath"))));
		System.out.println("**************no of result for Test2**************");
		System.out.println("***************************************************");
		System.out.println(getElement("Results_xpath").getText());
		Thread.sleep(2000);
	}
	
	//adding item to cart
	public void addtocart() throws InterruptedException
	{
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		new WebDriverWait(driver, 50)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("eleclick_xpath"))));
		clickElement("eleclick_xpath");
		
		 new WebDriverWait(driver, 30)
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("addtocart_xpath"))));
	  
		 clickElement("addtocart_xpath");
	
	}
	
	//navigating to homepage
	public void homepage() throws InterruptedException
	{
		 Thread.sleep(1000);
		 clickElement("Home_xpath");
	
}

	public static featuredfind nextPage() {
		// sending driver to next page
		return PageFactory.initElements(driver, featuredfind.class);
	}

}