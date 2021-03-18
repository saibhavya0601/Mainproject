package com.AutomationScript.Utils;



import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class FindBBQ1 extends BaseUI {
	 
	 	//clicking on the store button
		  public void testOne() throws InterruptedException
		  {
			 
			  clickElement("Redeem_xpath");
			  new WebDriverWait(driver, 50).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(prop.getProperty("ShopAll_xpath"))));
		  }
		  
		  //navigating to garden and outdoors
		  public void navigateBBQ()
		  {
			  clickElement("ShopAll_xpath");
			  clickElement("Garden_xpath");
			  clickElement("BBQ_xpath");
		  }
		  
		  //clicking on mazoria brand.
		  public void clickmazoria() throws InterruptedException
		  {
		  
			  new WebDriverWait(driver, 50).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(prop.getProperty("BrandFilter_xpath"))));
			  clickElement("BrandFilter_xpath");
			  Thread.sleep(5000);
			  List<WebElement> mz=getElements("Mazoria_xpath");
			  Iterator<WebElement> mzItr=mz.iterator();
			  mzItr.next().click();
		  }
		  
		  //sorting the elements from low to high
		  public void sortby() throws InterruptedException
		  {
			  Select dropDown=new Select(getElement("Sort_xpath"));
			  dropDown.selectByVisibleText("Price: Low to High");
			  
		  }
		  
		  //listing the elements
		  public void results()
		  {
			  new WebDriverWait(driver, 50)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Result1_xpath"))));
			  System.out.println("**********List of items for test1******************");
			  System.out.println("***************************************************");
			System.out.println(getElement("Result1_xpath").getText());
		  }
		  
		  //navigating to home page
		  public void homepage() throws InterruptedException
		  {
				Thread.sleep(1000);
				 clickElement("Home_xpath");
			 // driver.close();
		  }
		  

			public static FindBBQ2 nextPage() {
				// sending driver to next page
				return PageFactory.initElements(driver, FindBBQ2.class);
			}

	    
		  
}
