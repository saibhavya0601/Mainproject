package com.AutomationScript.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class trendingcategories extends BaseUI{

	//clicking on houses and home
  public void thirditem()
  {
		 /* new WebDriverWait(driver, 30)
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("eleview_xpath"))));
		  */
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)");
		  
		  new WebDriverWait(driver, 30)
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("home_xpath"))));
		  clickElement("home_xpath");
		  js.executeScript("window.scrollBy(0,800)");
  }
  
  		//clicking on the third item in bestsellers
		public void bestThirditem()
		{
		  new WebDriverWait(driver, 30)
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("bajaj_xpath"))));
		  clickElement("bajaj_xpath");
		}
		
		//adding the item to cart
		public void addtocart()
		{
		 new WebDriverWait(driver, 30)
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("cart_xpath"))));
		  
		 clickElement("cart_xpath");
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		  
		 public static secureCheckout nextPage() {
				// sending driver to next page
				return PageFactory.initElements(driver, secureCheckout.class);
			}
 
  }
  
		  

