package RunTest;

import java.io.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AutomationScript.Utils.BaseUI;
import com.AutomationScript.Utils.ExtentReportManager;
import com.AutomationScript.Utils.FindBBQ1;
import com.AutomationScript.Utils.FindBBQ2;
import com.AutomationScript.Utils.featuredfind;
import com.AutomationScript.Utils.secureCheckout;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameter;
import com.AutomationScript.Utils.trendingcategories;

public class TestClass extends BaseUI {

	ExtentReports report = ExtentReportManager.getReportInstance();

	public void open(String browser) throws Exception {

		openBrowserAndNavigateToPracto(browser);

	}

	@Parameters("browser")
	@Test(priority = 1)
	public void testOne(String browser) throws Exception {
		ExtentTest logger = report.createTest("testOne");
		open(browser);
		logger.log(Status.INFO, "Browser opened");
		FindBBQ1 bbq = new FindBBQ1();
		bbq.testOne();
		logger.log(Status.INFO, "Entered the store");
		bbq.navigateBBQ();
		logger.log(Status.INFO, "Navigated to BBQ and Grills Page");
		bbq.clickmazoria();
		logger.log(Status.INFO, "Brand Filter Mazoria selected");
		bbq.sortby();
		logger.log(Status.INFO, "Sort:Price Low to High Applied");
		bbq.results();
		logger.log(Status.INFO, "Results printed on console");
		bbq.homepage();
		logger.log(Status.INFO, "Returned to homepage");
		logger.log(Status.PASS, "Test Executed Successfully");
	}

	@Test(priority = 2)
	public void testTwo() throws Exception {
		ExtentTest logger = report.createTest("testTwo");
		FindBBQ2 bbq1 = FindBBQ1.nextPage(); // AutomateFindHospitals.nextPage();
		bbq1.testTwo();
		logger.log(Status.INFO, "Navigated to BBQ and Grills Page");
		bbq1.pricefilter();
		logger.log(Status.INFO, "Price Filter Applied");
		bbq1.sortby();
		logger.log(Status.INFO, "Sort:Price High to low Applied");
		bbq1.results1();
		logger.log(Status.INFO, "Results printed on console");
		bbq1.addtocart();
		logger.log(Status.INFO, "Item Added to cart");
		bbq1.homepage();
		logger.log(Status.INFO, "Returned to homepage");
		logger.log(Status.PASS, "Test Executed Successfully");
	}

	@Test(priority = 3)
	public void testThree() throws Exception {
		ExtentTest logger = report.createTest("testThree");
		featuredfind ff = FindBBQ2.nextPage();
		ff.testThree();
		logger.log(Status.INFO, "Clicked Apple Products");
		ff.screenshot();
		logger.log(Status.INFO, "Screenshot captured");
		ff.addtocart();
		logger.log(Status.INFO, "Item Added to cart");
		ff.homepage();
		logger.log(Status.INFO, "Returned to homepage");
		logger.log(Status.PASS, "Test Executed Successfully");
	}

	@Test(priority = 4)
	public void testfour() throws Exception {
		ExtentTest logger = report.createTest("testFour");
		trendingcategories tc = featuredfind.nextPage();
		tc.thirditem();
		logger.log(Status.INFO, "Selected third category in trending");
		tc.bestThirditem();
		tc.addtocart();
		logger.log(Status.INFO, "Item Added to cart");
		logger.log(Status.PASS, "Test Executed Successfully");
	}
	
	@Test(priority = 5)
	public void testfive() throws IOException, InterruptedException {
		ExtentTest logger = report.createTest("testFour");
		secureCheckout sc = trendingcategories.nextPage();
		sc.clicksecurecheckout();
		logger.log(Status.INFO, "Secured Checkout clicked");
		sc.enterdetails();
		logger.log(Status.INFO, "Specified Details Entered");
		logger.log(Status.PASS, "Test Executed Successfully");
		Thread.sleep(1000);
		close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}

	public void close() {
		BaseUI ba = new BaseUI();
		ba.closeBrowser();
	}
}
