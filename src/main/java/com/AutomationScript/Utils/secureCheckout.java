package com.AutomationScript.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class secureCheckout extends BaseUI {
	
	//clicking no the securecheckout
	public void clicksecurecheckout() throws IOException {

		new WebDriverWait(driver, 30).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("myshoppingcart_xpath"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		new WebDriverWait(driver, 30).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("securecheckout_xpath"))));
		clickElement("securecheckout_xpath");
	}
	
	//entering the invalid details
	public void enterdetails() throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"//Testdata//MainProjectTestdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheetAt(0);// sheet (1)
		XSSFRow wr = ws.getRow(1);
		XSSFCell wc = wr.getCell(0);
		XSSFCell wc1 = wr.getCell(1);
		XSSFCell wc2 = wr.getCell(2);
		XSSFCell wc3 = wr.getCell(3);
		XSSFCell wc4 = wr.getCell(4);
		XSSFCell wc5 = wr.getCell(5);
		XSSFCell wc6 = wr.getCell(6);
		XSSFCell wc7 = wr.getCell(7);
		String data1 = wc.getStringCellValue();
		String data2 = wc1.getStringCellValue();
		String data3 = wc2.getStringCellValue();
		String data4 = wc3.getStringCellValue();
		String data5 = wc4.getStringCellValue();
		String data6 = wc5.getStringCellValue();
		String data7 = wc6.getStringCellValue();
		String data8 = String.valueOf(wc7.getNumericCellValue());

		new WebDriverWait(driver, 50)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("personal_xpath"))));
		js.executeScript("window.scrollBy(0,300)");
		
		//entering firstname
		enterText("firstname_xpath", data1);
		
		//entering lastname
		enterText("lastname_xpath", data2);
		
		//entering emailid
		enterText("email_xpath", data3);
		
		//entering confirm emailid
		enterText("confirmemailtb_xpath", data4);
		
		//entering the address
		enterText("addressline1_xpath", data5);
		
		//entering the city
		enterText("city_xpath", data6);
		
		//entering the pincode
		enterText("pincode_xpath", data7);
		
		//entering the phonenumber
		enterText("phonenumber_xpath", data8);
		
		clickElement("continue_xpath");
		System.out.println("*********************output for test4***********************");
		System.out.println("************************************************************");
		System.out.println("Please correct the entries indicated below");

	}
}
