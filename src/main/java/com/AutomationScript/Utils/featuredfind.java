package com.AutomationScript.Utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class featuredfind extends BaseUI{

	  public void testThree() throws Exception{
			 new WebDriverWait(driver, 50).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(prop.getProperty("featuredFinds_xpath"))));
			 clickElement("appleProduct_xpath");
	  }
	  
	  
		public void screenshot() throws IOException
				{ 
					   //ScreenShot:
					   TakesScreenshot capture = (TakesScreenshot) driver;
					   File srcFile = capture.getScreenshotAs(OutputType.FILE);
					   File destFile = new File(System.getProperty("user.dir")+"//screenshots//Screen.png");
					    Files.copy(srcFile, destFile);
					    System.out.println("*****************Output for test3*********************");
					    System.out.println("ScreenShot Captured Successfully");
					    
					   
			     }
		
		public void addtocart() throws InterruptedException
		{
				 new WebDriverWait(driver, 50).until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(prop.getProperty("addToCart_xpath"))));
				 clickElement("addToCart_xpath");
		}
		
		public void homepage() throws InterruptedException
		{
				 Thread.sleep(1000);
				 clickElement("Home_xpath");
				
				
		}
		

		public static trendingcategories nextPage() {
			// sending driver to next page
			return PageFactory.initElements(driver, trendingcategories.class);
		}

}
