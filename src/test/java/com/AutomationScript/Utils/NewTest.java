package com.AutomationScript.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws IOException {
	  FileInputStream fi = new FileInputStream("E:\\MainProject1\\Testdata\\MainProjectTestdata.xlsx");
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
		String data8 =String.valueOf(wc7.getNumericCellValue());
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4);
		System.out.println(data5);
		System.out.println(data6);
		System.out.println(data7);
		System.out.println(data8);
		
  }
}
